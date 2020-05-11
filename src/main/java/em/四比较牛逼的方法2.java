package em;

import com.company.A;
import com.company.B;
import util.ReRun;
import util.ReRun2;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Frank on 2019/9/22.
 */
public class 四比较牛逼的方法2 {
    private static boolean flag = true;

    public static void setFlag(){
        flag = false;
    }
    public static void main(String[] args) throws Exception{
        if(flag) ReRun2.reRun(System.getProperty("user.dir")+ File.separator +"target"+ File.separator +"classes"+ File.separator, 四比较牛逼的方法2.class.getName(),args);

        new A().run();
        new B().run();
    }
}
