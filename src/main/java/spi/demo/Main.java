package spi.demo;

import cl.ReCL;
import spi.demo.api.SpiDemo;

import java.io.File;
import java.sql.DriverManager;
import java.util.ServiceLoader;

/**
 * @author Frank
 * @date 2020/5/10 16:34
 */
public class Main {
    public static void main(String[] args) {
//        Logger log
        Thread.currentThread().setContextClassLoader(new ReCL(System.getProperty("java.class.path")));
        ServiceLoader<SpiDemo> spiDemos = ServiceLoader.load(SpiDemo.class);
        for (SpiDemo spiDemo: spiDemos){
            spiDemo.hello("nick");
        }
    }
}
