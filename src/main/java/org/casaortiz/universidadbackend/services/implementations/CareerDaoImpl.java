package org.casaortiz.universidadbackend.services.implementations;

import org.casaortiz.universidadbackend.model.entities.Career;
import org.casaortiz.universidadbackend.repositories.CareerRepository;
import org.casaortiz.universidadbackend.services.agreement.CareerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //lo convierto un bean
public class CareerDaoImpl extends GenericDaoImpl<Career, CareerRepository> implements CareerDao {
    @Autowired
    public CareerDaoImpl(CareerRepository repository) {
        super(repository);
    }
}
