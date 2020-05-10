package cl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 继承自URLClassLoader，不用自己写加载字节码:)
 * @author Frank
 * @date 2020/5/7 2:00
 */
public class MyCL2 extends URLClassLoader {
    public MyCL2(URL[] urls) {
        super(urls);
    }
    public MyCL2(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }
}