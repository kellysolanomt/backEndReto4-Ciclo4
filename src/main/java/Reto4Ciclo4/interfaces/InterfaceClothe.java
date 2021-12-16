package Reto4Ciclo4.interfaces;

import Reto4Ciclo4.model.Clothe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterfaceClothe extends MongoRepository<Clothe, String> {

}
