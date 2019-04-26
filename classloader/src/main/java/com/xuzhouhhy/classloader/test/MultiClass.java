package com.xuzhouhhy.classloader.test;

/**
 * created by hanhongyun on 2019/3/25 11:04
 */
public class MultiClass {

    private int field = 1;

    private A mA;
    private B mB;

    public MultiClass(A a, B b) {
        mA = a;
        mB = b;
    }
}

class A{

    private int fieldA = 1;

}

class B{

    private int fieldB = 1;

}
