package com.xuzhouhhy.jvm.exceptiontest;

import java.util.ArrayList;

/**
 * created by hanhongyun on 2019/3/23 12:45
 */
public class OOMHeapSpace {

    /**
     *
     * -verbose:gc -Xmn10M -Xms20M -Xmx20M -XX:+PrintGC
     *
     * Exception message
     *
     *[GC (Allocation Failure)  8192K->4953K(19456K), 0.0086770 secs]
     * [GC (Allocation Failure) -- 13145K->19432K(19456K), 0.0158359 secs]
     * [Full GC (Ergonomics)  19432K->9767K(19456K), 0.1767214 secs]
     * [Full GC (Ergonomics)  17586K->15737K(19456K), 0.3450467 secs]
     * [Full GC (Allocation Failure) Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * 	at java.util.Arrays.copyOf(Arrays.java:3210)
     * 	at java.util.Arrays.copyOf(Arrays.java:3181)
     * 	at java.util.ArrayList.grow(ArrayList.java:261)
     * 	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
     * 	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
     * 	at java.util.ArrayList.add(ArrayList.java:458)
     * 	at com.xuzhouhhy.jvm.exceptiontest.OOMHeapSpace.main(OOMHeapSpace.java:28)
     *  15737K->15719K(19456K), 0.1473992 secs]
     * [Full GC (Ergonomics)  15849K->366K(19456K), 0.0650466 secs]
     */
   public static void main(String... args){
       ArrayList<OOMHeapSpace> memories = new ArrayList<>();

       while (true){
            memories.add(new OOMHeapSpace());
        }
   }

}
