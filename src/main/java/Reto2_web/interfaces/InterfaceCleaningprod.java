/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.interfaces;

import Reto2_web.modelo.Cleaningprod;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author laura
 */
public interface InterfaceCleaningprod extends MongoRepository<Cleaningprod, Integer>{
    
}
