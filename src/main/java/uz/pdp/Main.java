package uz.pdp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uz.pdp.config.MainMyConfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainMyConfig.class);
        MyBean myBean = context.getBean(MyBean.class);
        myBean.hi();
        MyBean2 myBean2 = context.getBean(MyBean2.class);
        myBean2.getMyBean().hi();

        Person person = context.getBean(Person.class);
        System.out.println(person);

        context.close();
    }
}