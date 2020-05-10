package util;

import cl.ReCL;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * Created by Frank on 2019/9/22.
 */
public class ReRun {

    public static void reRun(String classpath,String mainClass,String[] args) throws Exception{
        ReCL reCL = new ReCL(classpath);
        Class clazz = reCL.loadClass(mainClass);
        Method mainMethod = clazz.getMethod("main",String[].class);
        Method setFlagMethod = clazz.getDeclaredMethod("setFlag");
        setFlagMethod.invoke(null);
        mainMethod.invoke(null, (Object) args);
        System.exit(0);
    }
}
