package uz.pdp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("ioc-settings.xml");
//        MyBean myBean = context.getBean(MyBean.class);
//        myBean.hi();
        MyBean2 myBean2 = context.getBean(MyBean2.class);
        myBean2.getMyBean().hi();
    }
}