package em;

import cl.MyCL;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

/**
 * Created by Frank on 2019/9/22.
 */
public class 三简单粗暴的正确做法 {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader1 = new MyCL("C:\\Users\\Frank David\\Desktop\\cldemo\\lib","A.jar");
        ClassLoader loader2 = new MyCL("C:\\Users\\Frank David\\Desktop\\cldemo\\lib","B.jar");

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
