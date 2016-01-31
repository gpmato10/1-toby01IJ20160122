package springbook.user.dao;

import org.springframework.aop.framework.ProxyFactoryBean;

import java.util.Date;

/**
 * Created by dw on 2016. 1. 30..
 */
public class Ttt {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Date now = (Date) Class.forName("java.util.Date").newInstance();

        ProxyFactoryBean f;
    }
}
