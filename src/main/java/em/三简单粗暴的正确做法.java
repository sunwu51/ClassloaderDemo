package em;

import cl.MyCL;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

/**
 * 继承最原始的ClassLoader，自己写的加载字节码的类加载器
 * Created by Frank on 2019/9/22.
 */
public class 三简单粗暴的正确做法 {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String baseLibDir = System.getProperty("user.dir") + File.separator + "lib";

        ClassLoader loader1 = new MyCL(baseLibDir,"A.jar");
        ClassLoader loader2 = new MyCL(baseLibDir,"B.jar");

        Class clazzA = loader1.loadClass("com.company.A");
        Class clazzB = loader2.loadClass("com.company.B");

        Object a = clazzA.newInstance();
        Object b = clazzB.newInstance();

        Method runA = a.getClass().getDeclaredMethod("run");
        Method runB = b.getClass().getDeclaredMethod("run");

        runA.invoke(a,null);
        runB.invoke(b,null);
    }
}
