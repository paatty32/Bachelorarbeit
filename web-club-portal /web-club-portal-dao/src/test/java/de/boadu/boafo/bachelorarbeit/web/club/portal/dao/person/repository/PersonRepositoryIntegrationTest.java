package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void whenFindByName_thenReturnPerson(){

        Person patrick = new Person();
        patrick.setName("Patrick");

        testEntityManager.persist(patrick);
        testEntityManager.flush();

        Person found = personRepository.findPersonByName("Patrick");

        assertThat(found.getName()).isEqualTo(patrick.getName());

    }

    @Test
    public void whenNotFindByName_thenReturnNull(){

        Person found = personRepository.findPersonByName("Test");

        assertThat(found).isNull();

    }

    @Test
    public void whenFindBySurname_thenReturnPersonSurname(){

        Person surname = new Person();
        surname.setName("Mustermann");
        surname.setSurname("Max");

        testEntityManager.persist(surname);
        testEntityManager.flush();

        Person foundPerson = this.personRepository.findPersonBySurname("Max");

        assertThat(foundPerson.getSurname()).isEqualTo(surname.getSurname());

    }

    @Test
    public void whenNotFindBySurname_thenReturnNull(){

        Person notFoundPerson = this.personRepository.findPersonBySurname("NotFoundSurname");

        assertThat(notFoundPerson).isNull();

    }

    @Test
    public void whenSave_thenReturnPerson(){

        Person newPerson = new Person();
        newPerson.setName("Mustermann");
        newPerson.setSurname("Max");

        Person savedPerson = this.personRepository.save(newPerson);

        assertThat(savedPerson).hasFieldOrPropertyWithValue("name", "Mustermann");
        assertThat(savedPerson).hasFieldOrPropertyWithValue("surname", "Max");


    }



}
