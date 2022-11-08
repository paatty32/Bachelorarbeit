package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.user.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.user.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person save(Person person);

    Person findPersonByName(String name);
}
