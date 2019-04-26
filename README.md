# JavaLock
java lock test

## jvm 异常 oom vs StackOverFlow

参考资料
* [Java常见内存溢出异常分析](http://www.importnew.com/14604.html)
* [JVM—内存溢出、OutOfMemoryError、StackOverflowError](https://blog.csdn.net/u011936381/article/details/20039103)
* [Java JVM 3-内存区域OOM异常以及和StackOverFlowError的区别](https://blog.csdn.net/weixin_40739833/article/details/80715047)

module:jvm

### OOMHeapSpace.java

jvm运行参数 java -verbose:gc -Xmn10M -Xms20M -Xmx20M -XX:+PrintGC

[GC (Allocation Failure)  8192K->4953K(19456K), 0.0086770 secs]
[GC (Allocation Failure) -- 13145K->19432K(19456K), 0.0158359 secs]
[Full GC (Ergonomics)  19432K->9767K(19456K), 0.1767214 secs]
[Full GC (Ergonomics)  17586K->15737K(19456K), 0.3450467 secs]
[Full GC (Allocation Failure) Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at com.xuzhouhhy.jvm.exceptiontest.OOMHeapSpace.main(OOMHeapSpace.java:28)
 15737K->15719K(19456K), 0.1473992 secs]
[Full GC (Ergonomics)  15849K->366K(19456K), 0.0650466 secs]

### OOMPermGenSpace.java

jvm运行参数 java -verbose:gc -Xmn5M -Xms10M -Xmx10M -XX:MaxPermSize=1M -XX:+PrintGC

[GC (Allocation Failure)  4096K->776K(9728K), 0.0018210 secs]
[GC (Allocation Failure)  4872K->1172K(9728K), 0.0122757 secs]
[GC (Allocation Failure)  5268K->1608K(9728K), 0.0023394 secs]
[GC (Allocation Failure)  5704K->2042K(9728K), 0.0013720 secs]
[GC (Allocation Failure)  6138K->2494K(9728K), 0.0124112 secs]
[GC (Allocation Failure)  6590K->2910K(8704K), 0.0014934 secs]
[GC (Allocation Failure)  5982K->3295K(9216K), 0.0085567 secs]
[GC (Allocation Failure)  6367K->3623K(8192K), 0.0041423 secs]
[GC (Allocation Failure)  5671K->3847K(8704K), 0.0074811 secs]
[GC (Allocation Failure)  5895K->4079K(8704K), 0.0045500 secs]
[GC (Allocation Failure)  6127K->4279K(8704K), 0.0151086 secs]
[GC (Allocation Failure)  6327K->4696K(8704K), 0.0021009 secs]
[GC (Allocation Failure)  6744K->4928K(8704K), 0.0024618 secs]
[Full GC (Ergonomics)  4928K->4492K(8704K), 0.0421819 secs]
[Full GC (Ergonomics)  6540K->4691K(8704K), 0.0328926 secs]
 
重复的log 。。。
 
 [Full GC (Ergonomics)  7067K->7067K(8704K), 0.0216335 secs]
 [Full GC (Ergonomics)  7070K->7067K(8704K), 0.0200116 secs]
 [Full GC (Ergonomics)  7067K->7067K(8704K), 0.0163558 secs]
 [Full GC (Ergonomics) Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 	at java.lang.AbstractStringBuilder.<init>(AbstractStringBuilder.java:68)
 	at java.lang.StringBuilder.<init>(StringBuilder.java:89)
 	at java.util.UUID.toString(UUID.java:376)
 	at com.xuzhouhhy.jvm.exceptiontest.OOMPermGenSpace.main(OOMPermGenSpace.java:16)
  7067K->476K(8704K), 0.0103682 secs]
  
  ## ClassLoader
  
  module:classloader
  
  参考资料
  * [深入探讨 Java 类加载器](https://www.ibm.com/developerworks/cn/java/j-lo-classloader/#fig1)
  * [Android插件化原理解析——Hook机制之动态代理](http://weishu.me/2016/01/28/understand-plugin-framework-proxy-hook/)
  * [Android虚拟机框架：类加载机制](https://juejin.im/post/5a686596f265da3e2d339bb4#comment)
  
  思考题
  * 为什么用双亲委托模型、代理模式？
  * 为什么要自己写类加载器？
  * 一个java文件可以由多个class么？除了内部类呢？
  
  ## 反射
  
  参考资料 [Java 反射由浅入深 | 进阶必备](https://juejin.im/post/598ea9116fb9a03c335a99a4)
  
  ## ThreadLocal
  
  * 每个县城的副本保存在哪里？
  * 如何找到ThreadLocal对应的value？
  * ThreadLocalMap的作用？
  * ThreadLocal.withInitial()的作用？