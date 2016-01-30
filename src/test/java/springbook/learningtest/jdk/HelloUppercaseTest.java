package springbook.learningtest.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by dw on 2016. 1. 30..
 */
public class HelloUppercaseTest {
    @Test
    public void helloUppercaseTest() throws Exception {
        // 다이내믹 프록시를 이용하기 위해
        // 다이내믹 프록시를 생성하는 코드. 생성해서 proxiedHello 변수에 담는다.

        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] { Hello.class },
                new UppercaseHandler(new HelloTarget())
        );


    }
}
