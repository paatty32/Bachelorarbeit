package de.boadu.boafo.bachelorarbeit.web.club.portal;

import de.boadu.boafo.bachelorarbeit.web.club.portal.WebClubPortalApplication;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
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

}
