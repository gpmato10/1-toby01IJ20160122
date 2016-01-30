package springbook.learningtest.jdk;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
/**
 * Created by dw on 2016. 1. 30..
 */
public class HelloTargetTest {

    @Test
    public void simpleProxy() throws Exception {
        Hello hello = new HelloTarget();
        assertThat(hello.sayHello("Toby"), is("Hello Toby"));
        assertThat(hello.sayHi("Toby"), is("Hi Toby"));
        assertThat(hello.sayThankyou("Toby"), is("Thank you Toby"));
    }

    @Test
    public void uppercaseProxy() throws Exception {
        Hello proxiedHello = new HelloUppercase(new HelloTarget());
        assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
        assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
        assertThat(proxiedHello.sayThankyou("Toby"), is("THANK YOU TOBY"));
    }
}
