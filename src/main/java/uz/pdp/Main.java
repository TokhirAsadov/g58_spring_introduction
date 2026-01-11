package uz.pdp;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import uz.pdp.user.User;
import uz.pdp.user.UserDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc_settings.xml");
        UserDAO userDAO = context.getBean(UserDAO.class);
        User user = User.builder()
//                .id(3)
                .username("Elmurod")
                .password("666")
                .age(38)
                .build();
//        userDAO.save(user);
        /*User userDAOById = userDAO.findById(1);
        System.out.println("userDAO.findById() -> "+userDAOById);*/
        /*List<User> users = userDAO.findAll(15, 50);
        users.forEach(System.out::println);*/
//        userDAO.update(user);
//        userDAO.delete(3);
        Integer id = userDAO.save2(user);
        System.out.println("save2 -> id: "+id);
    }
}