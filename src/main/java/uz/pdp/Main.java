package uz.pdp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uz.pdp.config.AutoConfig;
import uz.pdp.entity.User;
import uz.pdp.repository.UserRepository;



public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = User.builder()
                .name("Ali Valiyev")
                .build();
        userRepository.save(user);
        System.out.println("User saved: " + user);

    }
}