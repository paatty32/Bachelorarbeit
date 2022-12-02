package de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingdiary;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingDiary.TrainingDiaryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class TrainingDiaryServiceImplTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private TrainingDiaryServiceImpl trainingDiaryService;

    @Test
    public void whenTrainingDiaryByUserIsThere_thenReturnTrainingDiary(){

        TrainingDiaryDto trainingDiary = TrainingDiaryDto.builder().build();
        Map<AppUserRole, Diary> personDiary = new HashMap<>();
        personDiary.put(AppUserRole.ROLE_ATHLETE, trainingDiary);

        Person person = new Person();
        person.setId(1L);
        person.setName("Mustermann");
        person.setSurname("Max");
        person.setDiary(personDiary);

        Mockito.when(personRepository.findPersonById(1L)).thenReturn(person);

        Long userId = 1L;

        TrainingDiary foundTrainingDiary = this.trainingDiaryService.getTrainingsDiaryByUser(userId);

        assertThat(foundTrainingDiary).isNotNull();

    }

    @Test
    public void whenTrainingDiaryByUserIsNotThere_thenReturnNull(){

        Map<AppUserRole, Diary> personDiary = new HashMap<>();

        Person person2 = new Person();
        person2.setId(2L);
        person2.setName("Mustermann");
        person2.setSurname("Max");
        person2.setDiary(personDiary);

        Mockito.when(personRepository.findPersonById(2L)).thenReturn(person2);

        Long userId = 2L;

        TrainingDiary notFoundDiary = this.trainingDiaryService.getTrainingsDiaryByUser(userId);

        assertThat(notFoundDiary).isNull();

    }




}
