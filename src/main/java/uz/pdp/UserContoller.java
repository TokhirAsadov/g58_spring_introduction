package uz.pdp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserContoller {
    private final Service service;

    @Autowired // @Inject
    public UserContoller(@Qualifier("userService") Service service) { // @Named
        this.service = service;
    }
}
