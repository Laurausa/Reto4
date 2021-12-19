/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.servicio;

import Reto2_web.modelo.Cleaningprod;
import Reto2_web.repositorio.CleaningprodRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class CleaningprodService {
    @Autowired
    private CleaningprodRepositorio clotheRepository;

    public List<Cleaningprod> getAll() {
        return clotheRepository.getAll();
    }

   public Optional<Cleaningprod> getClothe(int id) {
        return clotheRepository.getClothe(id);
    }

    public Cleaningprod create(Cleaningprod accesory) {
        if (accesory.getId() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Cleaningprod update(Cleaningprod accesory) {

        if (accesory.getId() != null) {
            Optional<Cleaningprod> accesoryDb = clotheRepository.getClothe(accesory.getId());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getName() != null) {
                    accesoryDb.get().setName(accesory.getName());
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

    public boolean delete(int id) {
        Boolean aBoolean = getClothe(id).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
