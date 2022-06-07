package org.casaortiz.universidadbackend;

import org.casaortiz.universidadbackend.model.entities.Career;
import org.casaortiz.universidadbackend.services.agreement.CareerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component //lo implementa como un bean
public class CareerCommands implements CommandLineRunner {//para que se ejecute como un main
    @Autowired //injecta la implementacion
    private CareerDao service; //curioso, llamo a la interfaces y no a la implementacion

    @Override
    public void run(String... args) throws Exception {
        /*Career ingSistemas = new Career(
                null,
                "Ingenieria en Sistemas",
                50,
                5
        );
        Career save = service.save(ingSistemas);
        System.out.println(save.toString());*/

        Career career = null;
        Optional<Career> oCarrer = service.findById(1);
        if(oCarrer.isPresent()){//si hay carrera
            career = oCarrer.get();
            System.out.println(career.toString());
        }else{
            System.out.println("Carrera no encontrada");
        }

        career.setAmountSubjectMatter(65);
        career.setNumberYears(6);

        service.save(career);

        System.out.println(service.findById(1).orElse(new Career()).toString());

        service.deleteById(1);

        System.out.println(service.findById(1).orElse(new Career()).toString());

    }
}
