package de.boadu.boafo.bachelorarbeit.web.club.portal.service.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    public void whenUserIsCreated_thenReturnUser(){

        Set<String> clickedRoles = new HashSet<>();
        clickedRoles.add("Athlet");

        MutablePerson person = new Person();
        person.setName("Mustermann");
        person.setSurname("Max");

        Mockito.when(personRepository.save((Person) person)).thenReturn((Person) person);

        Person createdPerson = this.personService.createUser(person, clickedRoles);

        assertThat(createdPerson).hasFieldOrPropertyWithValue("name", "Mustermann");
        assertThat(createdPerson).hasFieldOrPropertyWithValue("surname", "Max");

    }

}


