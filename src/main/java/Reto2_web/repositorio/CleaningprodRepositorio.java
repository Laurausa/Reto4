/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.repositorio;

import Reto2_web.interfaces.InterfaceCleaningprod;
import Reto2_web.modelo.Cleaningprod;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laura
 */
@Repository
public class CleaningprodRepositorio {
     @Autowired
    private InterfaceCleaningprod repository;

    public List<Cleaningprod> getAll() {
        return repository.findAll();
    }
    
    public Optional<Cleaningprod> getClothe(int id) {
        return repository.findById(id);
    }

    public Cleaningprod create(Cleaningprod clothe) {
        return repository.save(clothe);
    }

    public void update(Cleaningprod clothe) {
        repository.save(clothe);
    }
    
    public void delete(Cleaningprod clothe) {
        repository.delete(clothe);
    }
    
}
