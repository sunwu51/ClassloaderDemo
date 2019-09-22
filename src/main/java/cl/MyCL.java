package cl;

import java.io.*;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Frank on 2019/9/22.
 */
public class MyCL extends ClassLoader{

    private HashMap<String,Class> classes = new HashMap();
    private String classpath;
    private String jarName;

    public MyCL(String classpath,String jarName) {
        this.classpath = classpath;
        this.jarName = jarName;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(!name.startsWith("com.company")){
            return super.loadClass(name);
        }
        if(classes.containsKey(name)){
            return classes.get(name);
        }
        try {
            byte [] classDate=getDate(name);

            if(classDate==null){}

            else{
                //defineClass方法将字节码转化为类
//                 defineClass(name,classDate,0,classDate.length);
                Class c =  defineClass(name, classDate, 0, classDate.length, null);
                classes.put(name,c);
                return  c;
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return super.loadClass(name);
    }
    //返回类的字节码
    private byte[] getDate(String className) throws IOException{
        String tmp = className.replaceAll("\\.","/");
        JarFile jar = new JarFile(classpath+"/"+jarName);
        JarEntry entry = jar.getJarEntry(tmp + ".class");
        InputStream is = jar.getInputStream(entry);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = is.read();
        while (-1 != nextValue) {
            byteStream.write(nextValue);
            nextValue = is.read();
        }

        return byteStream.toByteArray();
    }
}