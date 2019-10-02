package com.slesarew.bottomnavigation.extension

import java.util.*
import kotlin.collections.ArrayList

fun <T> ArrayList<T>?.toStack(): Stack<T> = Stack<T>()
    .apply {
        this@toStack?.forEach {
            this.push(it)
        }
    }

fun <T> Stack<T>.toArrayList(): ArrayList<T> = ArrayList<T>()
    .apply {
        this@toArrayList.forEach {
            this.add(it)
        }
    }