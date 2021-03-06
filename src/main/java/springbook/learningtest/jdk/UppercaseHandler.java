package springbook.learningtest.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by dw on 2016. 1. 30..
 */
// 다이내믹 프록시 클래스
public class UppercaseHandler implements InvocationHandler {

    Object target;

    public UppercaseHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(target, args);
        if (ret instanceof  String && method.getName().startsWith("say")) { //메소드이름이'say'로 시작하는 경우만
            return ((String)ret).toUpperCase();
        }
        else {
            return ret;
        }
    }
}
