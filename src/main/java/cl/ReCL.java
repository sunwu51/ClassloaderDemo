package cl;

import java.io.*;

/**
 * Created by Frank on 2019/9/22.
 */
public class ReCL extends ClassLoader{

    private String classpath;

    public ReCL(String classpath) {
        this.classpath = classpath;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.startsWith("em")) {
            try {
                byte[] classDate = getDate(name);

                if (classDate == null) {
                } else {
                    //defineClass方法将字节码转化为类
                    return defineClass(name, classDate, 0, classDate.length);
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }else if(name.equals("com.company.A")){
            ClassLoader loader = new MyCL("C:\\Users\\Frank David\\Desktop\\cldemo\\lib","A.jar");
            return loader.loadClass("com.company.A");
        }
        else if(name.equals("com.company.B")){
            ClassLoader loader = new MyCL("C:\\Users\\Frank David\\Desktop\\cldemo\\lib","B.jar");
            return loader.loadClass("com.company.B");
        }

        return super.loadClass(name);
    }
    //返回类的字节码
    private byte[] getDate(String className) throws IOException{
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path=classpath + File.separatorChar +
                className.replace('.',File.separatorChar)+".class";
        try {
            in=new FileInputStream(path);
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len=0;
            while((len=in.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            in.close();
            out.close();
        }
        return null;
    }
}