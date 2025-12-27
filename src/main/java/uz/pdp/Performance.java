package uz.pdp;

import org.springframework.stereotype.Component;

import java.util.Random;

//@Component
public class Performance {

    public String perform(){
        if (new Random().nextBoolean()) {
            System.out.println("Konsert boshlandi..");
            return "Hello Spring AOP";
        } else {
            throw new RuntimeException("Xatolik sodir bo`ldi..");
        }

    }

}
