package com.griffithindustries.kotlin.common

import org.python.core.*
import java.util.*

// Kotlin allows 'extension methods' - elsewhere in the code, you can call a method with a receiver as if this method actually existed.

/**
 * Unwrap a Java Optional instance into a Kotlin nullable type
 */
fun <T> Optional<T>.toNullable(): T? = this.orElse(null)

/**
 * Wrap a Kotlin nullable type into a Java Optional instance
 */
fun <T> T?.toOptional(): Optional<T> = Optional.ofNullable(this)

/**
 * Inline functions (will be copied to their usage points by the compiler) can have reified type parameters; in short, this means there's 'runtime' access to an otherwise erased type.
 * In this case, we can use it to enable safer, more idiomatic Jython -> Java/Kotlin coercion.
 */
inline fun <reified T> PyObject.toJava(): T? = this.__tojava__(T::class.java) as? T

/**
 * The inverse of the previous operation - we can take any object (including a possibly null value) and wrap it into a Jython type.
 * This is equivalent to:
 * ```
 * return if (this != null) {
 *     Py.java2py(this)
 * } else {
 *     Py.None
 * }
 * ```
 */
fun Any?.toPy(): PyObject = this?.let { Py.java2py(it) } ?: Py.None
