package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person save(Person person);

    Person findPersonBySurname(String name);

    Person findPersonById(Long id);

    Person findPersonByName(String name);
}
