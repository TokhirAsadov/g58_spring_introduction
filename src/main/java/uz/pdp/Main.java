package uz.pdp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uz.pdp.config.MyConfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(MyConfig.class);
        context.refresh();
//        MyBean myBean = context.getBean(MyBean.class);
//        myBean.hi();
        MyBean2 myBean2 = context.getBean(MyBean2.class);
        myBean2.getMyBean().hi();

        context.close();
    }
}