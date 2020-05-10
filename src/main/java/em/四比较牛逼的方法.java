package em;

import cl.ReCL;
import com.company.A;
import com.company.B;
import util.ReRun;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Frank on 2019/9/22.
 */
public class 四比较牛逼的方法 {
    private static boolean flag = true;

    public static void setFlag(){
        flag = false;
    }
    public static void main(String[] args) throws Exception{
        if(flag) ReRun.reRun(System.getProperty("user.dir")+ File.separator +"target"+ File.separator +"classes",四比较牛逼的方法.class.getName(),args);

        new A().run();
        new B().run();
    }
}
