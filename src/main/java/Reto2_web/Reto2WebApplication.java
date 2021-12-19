package Reto2_web;

import Reto2_web.interfaces.InterfaceCleaningprod;
import Reto2_web.interfaces.InterfaceOrder;
import Reto2_web.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2WebApplication implements CommandLineRunner{
    @Autowired
    private InterfaceCleaningprod interfaceCleaningprod;
    
    @Autowired
    private InterfaceUser interfaceUser;
    
    @Autowired
    private InterfaceOrder interfaceOrder;
    
    public static void main(String[] args) {
		SpringApplication.run(Reto2WebApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        interfaceCleaningprod.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll();
    }

}
