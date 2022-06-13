package org.casaortiz.universidadbackend;

import org.casaortiz.universidadbackend.model.entities.Career;
import org.casaortiz.universidadbackend.services.agreement.CareerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component //lo implementa como un bean
public class CareerCommands implements CommandLineRunner {//para que se ejecute como un main
    @Autowired //injecta la implementacion
    private CareerDao service; //curioso, llamo a la interfaces y no a la implementacion

    @Override
    public void run(String... args) throws Exception {
        Career ingSistemas = new Career(
                null,
                "Ingenieria en Sistemas",
                60,
                5);
        Career ingIndustrial = new Career(
                null,
                "Ingenieria Industrial",
                55,
                5);
        Career ingAlimentos =  new Career(
                null,
                "Ingenieria en Alimentos",
                53,
                5);
        Career ingElectronica =  new Career(
                null,
                "Ingenieria Electronica",
                53,
                5);
        Career licSistemas =  new Career(
                null,
                "Licenciatura en Sistemas",
                40,
                4);
        Career licTurismo =  new Career(
                null,
                "Licenciatura en Turismo",
                42,
                4);
        Career licYoga =  new Career(
                null,
                "Licenciatura en Yoga",
                25,
                3);
        Career licRecursos =  new Career(
                null,
                "Licenciatura en Recursos Humanos",
                33,
                3);

        /*service.save(ingSistemas);
        service.save(ingIndustrial);
        service.save(ingAlimentos);
        service.save(ingElectronica);
        service.save(licSistemas);
        service.save(licTurismo);
        service.save(licYoga);
        service.save(licRecursos);*/

        List<Career> carrers = (List<Career>) service.findAll();
        carrers.forEach(c -> System.out.println(c));




        ///OTHER SECTION ====================================
       /* Career ingSistemas = new Career(
                null,
                "Ingenieria en Sistemas",
                50,
                5
        );
        Career save = service.save(ingSistemas);
        System.out.println(save.toString());

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

        System.out.println(service.findById(1).orElse(new Career()).toString());*/

    }
}
