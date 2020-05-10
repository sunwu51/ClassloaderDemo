package spi.demo.ins;

import spi.demo.api.SpiDemo;

/**
 * @author Frank
 * @date 2020/5/10 16:19
 */
public class SpiDemoImpl1 implements SpiDemo {
    @Override
    public void hello(String name) {
        System.out.println("impl1 ---" + name);
    }
}
