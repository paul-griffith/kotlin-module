package com.griffithindustries.kotlin.common

import org.python.core.*
import java.util.*

fun <T> Optional<T>.toNullable(): T? = this.orElse(null)

fun <T> T?.toOptional(): Optional<T> = Optional.ofNullable(this)

inline fun <reified T> PyObject.toJava(): T? = this.__tojava__(T::class.java) as? T

fun Any?.toPy(): PyObject = this?.let { Py.java2py(it) } ?: Py.None

