package cl;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Frank
 * @date 2020/5/12 1:00
 */
public class ReCL2 extends URLClassLoader {

    private Map<String, ClassLoader> classLoaderMap = new Hashtable<>();

    public ReCL2(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.equals("com.company.A")){
            String baseLibDir = System.getProperty("user.dir") + File.separator + "lib";
            try {
                ClassLoader loader = null;
                if (classLoaderMap.containsKey(name)) {
                    loader = classLoaderMap.get(name);
                } else {
                    loader = new URLClassLoader(new URL[]{new URL("file:" + baseLibDir + File.separator + "A.jar")},null);
                    classLoaderMap.put(name, loader);
                }
                return loader.loadClass(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(name.equals("com.company.B")){
            String baseLibDir = System.getProperty("user.dir") + File.separator + "lib";
            try {
                ClassLoader loader = null;
                if (classLoaderMap.containsKey(name)) {
                    loader = classLoaderMap.get(name);
                } else {
                    loader = new URLClassLoader(new URL[]{new URL("file:" + baseLibDir + File.separator + "B.jar")},null);
                    classLoaderMap.put(name, loader);
                }
                return loader.loadClass(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.loadClass(name);
    }
}
