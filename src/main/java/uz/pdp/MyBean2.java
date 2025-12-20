package uz.pdp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean2 {

    private final MyBean myBean;

    // CI - Constructor Injection
    @Autowired // Spring 4.1
    public MyBean2(MyBean myBean){
        this.myBean = myBean;
    }

    public MyBean getMyBean() {
        return myBean;
    }
}
