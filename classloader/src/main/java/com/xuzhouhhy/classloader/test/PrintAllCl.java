package com.xuzhouhhy.classloader.test;

/**
 * created by hanhongyun on 2019/3/23 16:32
 */
public class PrintAllCl {

    public static void main(String... args) {
        ClassLoader classLoader = PrintAllCl.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.getClass().getName());
            classLoader = classLoader.getParent();
        }


        ClassLoader stringClassLoader = Thread.class.getClassLoader();
        while (stringClassLoader != null) {
            System.out.println(stringClassLoader.getClass().getName());
            stringClassLoader = stringClassLoader.getParent();
        }

    }

}
