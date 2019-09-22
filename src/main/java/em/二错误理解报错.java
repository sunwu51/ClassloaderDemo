package em;

import cl.MyCL;
import com.company.A;
import com.company.B;

/**
 * Created by Frank on 2019/9/22.
 */
public class 二错误理解报错 {
    public static void main(String[] args) {
        ClassLoader loader = new MyCL("C:\\Users\\Frank David\\Desktop\\cldemo\\lib","A.jar");
        Thread.currentThread().setContextClassLoader(loader);
        new A().run();
        loader = new MyCL("C:\\Users\\Frank David\\Desktop\\cldemo\\lib","B.jar");
        Thread.currentThread().setContextClassLoader(loader);
        new B().run();

    }
}
