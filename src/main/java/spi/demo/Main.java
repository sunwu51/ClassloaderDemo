package spi.demo;

import spi.demo.api.SpiDemo;

import java.util.ServiceLoader;

/**
 * @author Frank
 * @date 2020/5/10 16:34
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<SpiDemo> spiDemos = ServiceLoader.load(SpiDemo.class);
        for (SpiDemo spiDemo: spiDemos){
            spiDemo.hello("nick");
        }

    }
}
