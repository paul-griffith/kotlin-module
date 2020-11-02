package com.griffithindustries.kotlin.common

import com.inductiveautomation.ignition.common.script.*
import com.inductiveautomation.ignition.common.script.abc.*
import com.inductiveautomation.ignition.common.script.hints.ScriptFunction
import org.dhatim.fastexcel.reader.*
import org.python.core.*
import org.python.core.adapter.*
import java.io.*

object FastExcelWrapper {
    init {
        Py.getAdapter().addPreClass(ReadableWorkbookAdapter())
        Py.getAdapter().addPreClass(RowAdapter())
    }

    @JvmStatic
    @ScriptFunction(docBundlePrefix = "system.excel")
    fun readFile(args: Array<PyObject>, kwargs: Array<String>): ReadableWorkbook {
        val parsedArgs = PyArgParser.parseArgs(args,
            kwargs,
            arrayOf("filepath"),
            arrayOf(String::class.java),
            "readFile")
        val filepath = parsedArgs.requireString("filepath")
        return ReadableWorkbook(File(filepath))
    }
}

class ReadableWorkbookAdapter : PyObjectAdapter {
    override fun canAdapt(obj: Any?) = obj is ReadableWorkbook

    override fun adapt(obj: Any?) = PyReadableWorkbook(obj as ReadableWorkbook)
}

class RowAdapter : PyObjectAdapter {
    override fun canAdapt(obj: Any?) = obj is Row

    override fun adapt(obj: Any?) = PyRow(obj as Row)
}

data class PyReadableWorkbook(private val workbook: ReadableWorkbook) : PyObject() {
    override fun __finditem__(key: PyObject?): PyObject {
        return when(key) {
            is PyInteger -> workbook.getSheet(key.asIndex()).toNullable()
            is PyBaseString -> workbook.findSheet(key.asString()).toNullable()
            else -> null
        }.toPy()
    }
}

data class PyRow(private val row: Row) : AbstractJythonSequence(PyRow::class.java) {
    override fun __add__(other: PyObject?): PyObject {
        return row.getCells(0, row.cellCount).toPy().__add__(other)
    }

    override fun pyget(index: Int): PyObject {
        return row.getCell(index).toPy()
    }

    override fun getslice(start: Int, stop: Int, step: Int): PyObject {
        return row.getCells(start, stop).toPy()
    }

    override fun repeat(count: Int): PyObject {
        return row.getCells(0, row.cellCount).toPy().__mul__(Py.newInteger(count))
    }

    override fun index(p0: PyObject?): Int {
        return row.indexOfFirst { it.value == p0 }
    }

    override fun count(p0: PyObject?): PyInteger {
        return row.count { it.value == p0 }.let { Py.newInteger(it) }
    }
}
