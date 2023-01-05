package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.PersonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonDTORepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void whenFindByName_thenReturnPerson(){

        PersonDTO patrick = new PersonDTO();
        patrick.setName("Patrick");

        testEntityManager.persist(patrick);
        testEntityManager.flush();

        PersonDTO found = personRepository.findPersonByName("Patrick");

        assertThat(found.getName()).isEqualTo(patrick.getName());

    }

    @Test
    public void whenNotFindByName_thenReturnNull(){

        PersonDTO found = personRepository.findPersonByName("Test");

        assertThat(found).isNull();

    }

    @Test
    public void whenFindBySurname_thenReturnPersonSurname(){

        PersonDTO surname = new PersonDTO();
        surname.setName("Mustermann");
        surname.setSurname("Max");

        testEntityManager.persist(surname);
        testEntityManager.flush();

        PersonDTO foundPersonDTO = this.personRepository.findPersonBySurname("Max");

        assertThat(foundPersonDTO.getSurname()).isEqualTo(surname.getSurname());

    }

    @Test
    public void whenNotFindBySurname_thenReturnNull(){

        PersonDTO notFoundPersonDTO = this.personRepository.findPersonBySurname("NotFoundSurname");

        assertThat(notFoundPersonDTO).isNull();

    }

    @Test
    public void whenSave_thenReturnPerson(){

        PersonDTO newPersonDTO = new PersonDTO();
        newPersonDTO.setName("Mustermann");
        newPersonDTO.setSurname("Max");

        PersonDTO savedPersonDTO = this.personRepository.save(newPersonDTO);

        assertThat(savedPersonDTO).hasFieldOrPropertyWithValue("name", "Mustermann");
        assertThat(savedPersonDTO).hasFieldOrPropertyWithValue("surname", "Max");


    }



}
