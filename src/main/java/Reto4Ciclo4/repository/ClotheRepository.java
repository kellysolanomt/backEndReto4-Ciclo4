package Reto4Ciclo4.repository;

import Reto4Ciclo4.interfaces.InterfaceClothe;
import Reto4Ciclo4.model.Clothe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClotheRepository {
    @Autowired
    private InterfaceClothe clotheCrudRepository;

    public List<Clothe> getAll(){
        return clotheCrudRepository.findAll();
    }

    public Optional<Clothe> getClothe(String reference){
        return clotheCrudRepository.findById(reference);
    }

    public Clothe create(Clothe clothe){
        return clotheCrudRepository.save(clothe);
    }
    public void update(Clothe clothe){
        clotheCrudRepository.save(clothe);
    }
    public void delete(Clothe clothe){
        clotheCrudRepository.delete(clothe);
    }
}
