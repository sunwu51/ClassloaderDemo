package em;

import cl.MyCL;
import cl.MyCL2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 继承URLClassLoader，不用自己写字节码加载。parent要写null
 * Created by Frank on 2019/9/22.
 */
public class 三简单粗暴的正确做法2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        String baseLibDir = System.getProperty("user.dir") + File.separator + "lib";
        MyCL2 loader1 = new MyCL2(new URL[]{new URL("file:" + baseLibDir + File.separator + "A.jar")},null);
        MyCL2 loader2 = new MyCL2(new URL[]{new URL("file:" + baseLibDir + File.separator + "B.jar")},null);
        MyCL2 loader3 = new MyCL2(new URL[]{new URL("file:" + System.getProperty("user.dir") + File.separator + "target\\classes")});



        Class clazzA = loader1.loadClass("com.company.A");
        Class clazzB = loader2.loadClass("com.company.B");
        Class clazzC = loader3.loadClass("em.三简单粗暴的正确做法2");

        Object a = clazzA.newInstance();
        Object b = clazzB.newInstance();

        Method runA = a.getClass().getDeclaredMethod("run");
        Method runB = b.getClass().getDeclaredMethod("run");

        runA.invoke(a,null);
        runB.invoke(b,null);
    }
}
