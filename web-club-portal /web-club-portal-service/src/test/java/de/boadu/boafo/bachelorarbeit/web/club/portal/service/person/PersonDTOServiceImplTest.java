package de.boadu.boafo.bachelorarbeit.web.club.portal.service.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.repository.CompetitionDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.repository.TrainingsDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.repository.TrainingPlanRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.PersonDTO;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PersonDTOServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private CompetitionDiaryRepository competitionDiaryRepository;

    @Mock
    private TrainingsDiaryRepository trainingsDiaryRepository;

    @Mock
    private TrainingPlanRepository trainingPlanRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    public void whenUserIsCreated_thenReturnUser(){

        Set<String> clickedRoles = new HashSet<>();
        clickedRoles.add("Athlet");

        MutablePerson person = new PersonDTO();
        person.setName("Mustermann");
        person.setSurname("Max");

        Mockito.when(personRepository.save((PersonDTO) person)).thenReturn((PersonDTO) person);

        PersonDTO createdPersonDTO = this.personService.createUser(person, clickedRoles);

        assertThat(createdPersonDTO).hasFieldOrPropertyWithValue("name", "Mustermann");
        assertThat(createdPersonDTO).hasFieldOrPropertyWithValue("surname", "Max");

    }

}


