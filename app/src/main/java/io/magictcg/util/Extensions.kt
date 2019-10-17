package io.magictcg.util

import retrofit2.Call
import java.io.IOException

infix fun String.and(value: String): String = "$this,$value"
infix fun String.or(value: String): String = "$this|$value"

fun <T> Call<T>.result(): T {
    return execute().let {
        if (it.isSuccessful) it.body() !! else throw IOException("[${it.code()}]: ${it.message()}")
    }
}