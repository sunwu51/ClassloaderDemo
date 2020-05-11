package util;

import cl.ReCL;
import cl.ReCL2;

import java.lang.reflect.Method;
import java.net.URL;

/**
 * Created by Frank on 2019/9/22.
 */
public class ReRun2 {

    public static void reRun(String classpath,String mainClass,String[] args) throws Exception{
        ReCL2 reCL = new ReCL2(new URL[]{new URL("file:"+ classpath)},null);
        Class clazz = reCL.loadClass(mainClass);
        Method mainMethod = clazz.getMethod("main",String[].class);
        Method setFlagMethod = clazz.getDeclaredMethod("setFlag");
        setFlagMethod.invoke(null);
        mainMethod.invoke(null, (Object) args);
        System.exit(0);
    }
}
