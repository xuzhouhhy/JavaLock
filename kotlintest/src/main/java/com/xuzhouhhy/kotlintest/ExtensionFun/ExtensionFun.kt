package com.xuzhouhhy.kotlintest.ExtensionFun

/**
 * created by hanhongyun on 2019/3/27 17:51
 *
 */
fun Int.double(): Int {
    return this + this
}


class ExtensionFun() {

    val age = 3.double()

}

