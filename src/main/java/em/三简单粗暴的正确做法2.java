package em;

import cl.MyCL;
import cl.MyCL2;
import com.company.A;
import com.company.B;

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
        ClassLoader loader1 = new URLClassLoader(new URL[]{new URL("file:" + baseLibDir + File.separator + "A.jar")},null);
        ClassLoader loader2 = new URLClassLoader(new URL[]{new URL("file:" + baseLibDir + File.separator + "B.jar")},null);



        Class clazzA = loader1.loadClass(A.class.getName());
        Class clazzB = loader2.loadClass(B.class.getName());

        Object a = clazzA.newInstance();
        Object b = clazzB.newInstance();

        Method runA = a.getClass().getDeclaredMethod("run");
        Method runB = b.getClass().getDeclaredMethod("run");

        runA.invoke(a,null);
        runB.invoke(b,null);
    }
}
