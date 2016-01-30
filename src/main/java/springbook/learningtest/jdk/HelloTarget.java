package springbook.learningtest.jdk;

/**
 * Created by dw on 2016. 1. 30..
 */
public class HelloTarget implements Hello {
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
