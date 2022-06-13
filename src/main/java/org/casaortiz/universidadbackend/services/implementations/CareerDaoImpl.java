package org.casaortiz.universidadbackend.services.implementations;

import org.casaortiz.universidadbackend.model.entities.Career;
import org.casaortiz.universidadbackend.repositories.CareerRepository;
import org.casaortiz.universidadbackend.services.agreement.CareerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //lo convierto un bean
public class CareerDaoImpl extends GenericDaoImpl<Career, CareerRepository> implements CareerDao {
    @Autowired
    public CareerDaoImpl(CareerRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findCareersByNameContains(String name) {
        return repository.findCareersByNameContains(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findCareersByNameIgnoreCase(String name) {
        return repository.findCareersByNameIgnoreCase(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findCareersByNumberYearsAfter(Integer numberYears) {
        return findCareersByNumberYearsAfter(numberYears);
    }
}
