package org.casaortiz.universidadbackend.services.implementations;

import org.casaortiz.universidadbackend.model.entities.Career;
import org.casaortiz.universidadbackend.repositories.CareerRepository;
import org.casaortiz.universidadbackend.services.agreement.CareerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CareerDaoImpl implements CareerDao {
    @Autowired //inyecta la dependencia de nuestro repository
    private CareerRepository careerRepository;

    @Override
    @Transactional(readOnly = true) //debe de derivar de springframework, no de javax
    public Optional<Career> findById(Integer id) {
        return careerRepository.findById(id);
    }

    @Override
    @Transactional
    public Career save(Career career) {
        return careerRepository.save(career);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findAll() {
        return careerRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        careerRepository.deleteById(id);
    }
}
