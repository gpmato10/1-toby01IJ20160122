package springbook.learningtest.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by dw on 2016. 1. 30..
 */
public class HelloUppercaseTest {
    @Test
    public void helloUppercaseTest() throws Exception {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] { Hello.class },
                new UppercaseHandler(new HelloTarget())
        );


    }
}
