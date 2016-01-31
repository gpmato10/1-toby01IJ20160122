package springbook.learningtest.jdk.proxy;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import springbook.learningtest.jdk.Hello;
import springbook.learningtest.jdk.HelloTarget;
import springbook.learningtest.jdk.UppercaseHandler;

import java.lang.reflect.Proxy;

/**
 * Created by dw on 2016. 1. 31..
 */
public class DynamicProxyTest {
    @Test
    public void simpleProxy() throws Exception {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{Hello.class},
                new UppercaseHandler(new HelloTarget()));

//        assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
//        assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
//        assertThat(proxiedHello.sayThankyou("Toby"), is("THANK YOU TOBY"));
    }

    @Test
    public void proxyFactoryBean() throws Exception {
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget());
        pfBean.addAdvice(new UppercaseAdvice()); // 부가기능을 담은 어드바이스를 추가한다. 여러개를 추가할 수도 있다.

        Hello proxiedHello = (Hello) pfBean.getObject();// FactoryBean 이므로 getObject()로 생성된 프록시를 가져온다.
        assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
        assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
        assertThat(proxiedHello.sayThankyou("Toby"), is("THANK YOU TOBY"));
    }

    static class UppercaseAdvice implements MethodInterceptor {
        public Object invoke(MethodInvocation invocation) throws Throwable {
            String ret = (String) invocation.proceed(); // 리플렉션 Method와 달리, 실행시 타깃 오브젝트를 전달할 필요 없다
            // MethodInvocation 은 메소드 정보와함께 타깃 오브젝트를 알고 있기 때문이다.

            return ret.toUpperCase();   // 부가기능 적용.
        }
    }

    static interface Hello {
        String sayHello(String name);
        String sayHi(String name);
        String sayThankyou(String name);
    }

    static class HelloTarget implements Hello {
        @Override
        public String sayHello(String name) {
            return "Hello " + name;
        }
        @Override
        public String sayHi(String name) {
            return "Hi " + name;
        }
        @Override
        public String sayThankyou(String name) {
            return "Thank you " + name;
        }
    }
}
