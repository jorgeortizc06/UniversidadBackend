package org.casaortiz.universidadbackend;

import org.casaortiz.universidadbackend.model.entities.Address;
import org.casaortiz.universidadbackend.model.entities.Person;
import org.casaortiz.universidadbackend.model.entities.Student;
import org.casaortiz.universidadbackend.services.agreement.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversidadBackendApplication {
    @Autowired
    private StudentDao studentDao;

    public static void main(String[] args) {
        //getBeanDefinitionNames = Return array de strings con los beans
        String[] beanDefinitionNames = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();
        /*for (String str: beanDefinitionNames) {
            System.out.println(str); //imprime beans que a generado Spring
        }*/
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            Address address = new Address("calle falsa","123","1623","","");
            Person student = new Student(
                    null,
                    "Raul",
                    "Perez",
                    "1111111111",
                    address
            );

            Person studentSave = studentDao.save(student);
            System.out.println(studentSave.toString());
        };
    }

}
