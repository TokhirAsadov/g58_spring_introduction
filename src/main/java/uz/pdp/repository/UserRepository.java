package uz.pdp.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Component;
import uz.pdp.entity.User;

@Component
public interface UserRepository extends CrudRepository<User, Integer> {
}
