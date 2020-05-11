# 说明
使用classloader解决依赖冲突，视频地址https://www.bilibili.com/video/av68658611


运行前,需要将lib目录添加为依赖目录，添加方式  
![image](https://bolg.obs.cn-north-1.myhuaweicloud.com/1909/2019-09-28_20-18-05.png)
## 依赖说明
项目依赖于A.jar和B.jar。A依赖C的1.0版本，B依赖C的2.0版本。
## 双亲委派
用户程序中默认使用Appclassloader加载，只能加载一个C。所以AB必有一个不能正常使用，使用自定义classloader解决该问题，更多细节参见视频连接。
## SPI
除了上面的打破双亲解决冲突，该仓库在spi包下还演示了java中spi的用法。

主要思想就是在resources/META-INF/services目录下，放置一个以`全限定接口名`命名的文件，在里面每行写实现该接口的类名。而后通过
```java
ServiceLoader<SpiDemo> spiDemos = ServiceLoader.load(SpiDemo.class);
```
就可以获取实现了该接口的类的实例集合（用的是默认构造方法）。

SPI是动态加载类，使用的也是AppClassLoader。他主要作用和场景是，