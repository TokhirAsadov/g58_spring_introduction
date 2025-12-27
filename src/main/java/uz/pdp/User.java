package uz.pdp;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ToString
@PropertySource("classpath:application.properties")
public class User {
    @Value("#{'Asadov'.toUpperCase()}")
    private String lastName;

    @Value("#{'Tohir'.toUpperCase()}")
    private String firstName;

    @Value("#{'AsaDov123'.toLowerCase()}")
    private String username;

    @Value("${user.company}")
    private String company;

    @Value("${user.experience:10}")
    private Integer experience;

    @Value("#{{1, 30, 40}}")
    private List<Integer> numbers;

    @Value("#{4 < 2 ?: 'Kichik'}")
    private String ternaryOperation;
}
