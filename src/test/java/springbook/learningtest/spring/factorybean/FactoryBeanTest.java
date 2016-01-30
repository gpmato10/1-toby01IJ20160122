package springbook.learningtest.spring.factorybean;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dw on 2016. 1. 30..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/FactoryBeanTest-context.xml")
public class FactoryBeanTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void getMessageFromFactoryBean() throws Exception {
        Object message = context.getBean("message");
        assertThat(message, is(Message.class));
        assertThat(((Message)message).getText(), is("Factory Bean"));
    }
}
