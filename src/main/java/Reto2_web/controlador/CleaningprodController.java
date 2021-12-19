/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.controlador;

import Reto2_web.modelo.Cleaningprod;
import Reto2_web.servicio.CleaningprodService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laura
 */
@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class CleaningprodController {
    @Autowired
    private CleaningprodService accessoryService;
       
     @GetMapping("/all")
    public List<Cleaningprod> getAll() {
        return accessoryService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cleaningprod> getClothe(@PathVariable("id") Integer id) {
        return accessoryService.getClothe(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cleaningprod create(@RequestBody Cleaningprod gadget) {
        return accessoryService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cleaningprod update(@RequestBody Cleaningprod gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return accessoryService.delete(id);
    } 
    
}
