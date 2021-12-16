package Reto4Ciclo4.interfaces;

import Reto4Ciclo4.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InterfaceUser extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
}
