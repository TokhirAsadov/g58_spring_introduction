package uz.pdp;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import uz.pdp.user.User;
import uz.pdp.user.UserDAO;
import uz.pdp.user.UserDAO2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc_settings.xml");
        UserDAO userDAO = context.getBean(UserDAO.class);
        UserDAO2 userDAO2 = context.getBean(UserDAO2.class);
        User user = User.builder()
//                .id(7)
                .username("Umar")
                .password("989")
                .age(14)
                .build();
//        userDAO.save(user);
        /*User userDAOById = userDAO.findById(1);
        System.out.println("userDAO.findById() -> "+userDAOById);*/
        /*List<User> users = userDAO.findAll(15, 50);
        users.forEach(System.out::println);*/
//        userDAO.update(user);
//        userDAO.delete(3);
//        Integer id = userDAO.save2(user);
//        System.out.println("save2 -> id: "+id);

//        Integer id = userDAO2.save2(user);
//        System.out.println("userDAO2.save2 -> id: "+id);
//        userDAO2.save(user);
        /*User userDAO2ById = userDAO2.findById(7);
        System.out.println(userDAO2ById);*/
//        userDAO2.findAll().forEach(System.out::println);
//        userDAO2.findAll(18, 40).forEach(System.out::println);
        userDAO2.delete(7);

    }
}