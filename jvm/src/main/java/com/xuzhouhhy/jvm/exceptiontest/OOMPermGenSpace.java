package com.xuzhouhhy.jvm.exceptiontest;

import java.util.ArrayList;
import java.util.UUID;

/**
 * created by hanhongyun on 2019/3/23 13:11
 */
public class OOMPermGenSpace {

    public static void main(String... args){

        ArrayList<String> consts = new ArrayList<>();

        while (true){
            consts.add(UUID.randomUUID().toString().intern());
        }

    }

}
