package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.PersonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonDTO, Long> {

    PersonDTO save(PersonDTO personDTO);

    PersonDTO findPersonBySurname(String surname);

    PersonDTO findPersonById(Long id);

    PersonDTO findPersonByName(String name);
}
