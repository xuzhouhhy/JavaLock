package com.xuzhouhhy.jvm.exceptiontest;

/**
 * created by hanhongyun on 2019/3/23 13:54
 */
public class StackOverFlowError {

    private int depth;

    public static void main(String... args) {
        new StackOverFlowError().addHeap();
    }

    private void addHeap() {
        addHeap();
        System.out.println("depth is :" + depth++);
    }

}
