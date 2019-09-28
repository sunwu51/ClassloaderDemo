# 说明
使用classloader解决依赖冲突，视频地址https://www.bilibili.com/video/av68658611


运行前,需要将lib目录添加为依赖目录，添加方式  
![image](https://bolg.obs.cn-north-1.myhuaweicloud.com/1909/2019-09-28_20-18-05.png)
## 依赖说明
项目依赖于A.jar和B.jar。A依赖C的1.0版本，B依赖C的2.0版本。
## 双亲委派
用户程序中默认使用Appclassloader加载，只能加载一个C。所以AB必有一个不能正常使用，使用自定义classloader解决该问题，更多细节参见视频连接。