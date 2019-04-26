package com.xuzhouhhy.kotlintest.classdesign

/**
 * created by hanhongyun on 2019/3/28 15:01
 *
 */
open class A(var a: Int) {

    open fun double(): Int = a + a

}

class B(money: Int) : A(money) {

    override fun double(): Int {
        System.out.println(a)
        return super.double()
    }
}