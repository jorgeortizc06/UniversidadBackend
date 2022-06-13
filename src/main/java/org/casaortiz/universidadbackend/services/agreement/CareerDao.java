package org.casaortiz.universidadbackend.services.agreement;

import org.casaortiz.universidadbackend.model.entities.Career;

/**
 * Interfaces de los metodos a usar en el CRUD
 */
public interface CareerDao extends GenericDao<Career>{

    Iterable<Career> findCareersByNameContains(String name);
    Iterable<Career> findCareersByNameIgnoreCase(String name);
    Iterable<Career> findCareersByNumberYearsAfter(Integer numberYears);

}
