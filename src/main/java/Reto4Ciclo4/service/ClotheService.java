package Reto4Ciclo4.service;

import Reto4Ciclo4.model.Clothe;
import Reto4Ciclo4.repository.ClotheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClotheService {
    @Autowired
    private ClotheRepository clotheRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Clothe> getAll(){
        return clotheRepository.getAll();
    }
    public Optional<Clothe> getClothe(String reference){
        return clotheRepository.getClothe(reference);
    }
    public Clothe create(Clothe accesory){
        if(accesory.getReference()==null){
            return accesory;
        }else{
            return clotheRepository.create(accesory);
        }
    }
    public Clothe update(Clothe accesory) {

        if (accesory.getReference() != null) {
            Optional<Clothe> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getSize()!= null) {
                    accesoryDb.get().setSize(accesory.getSize());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
