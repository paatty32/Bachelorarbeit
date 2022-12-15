package de.boadu.boafo.bachelorarbeit.web.club.portal.service.diary.trainingdiaryentry;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.repository.TrainingsDiaryEntryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingdiaryentry.TrainingDiaryEntryServiceImpl;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@Getter
public class TrainingDiaryEntryServiceImplTest {

    @Mock
    private TestEntityManager testEntityManager;

    @Mock
    TrainingsDiaryEntryRepository trainingsDiaryEntryRepository;

    @InjectMocks
    TrainingDiaryEntryServiceImpl trainingDiaryEntryService;

    @Test
    public void whenTrainingEntryIsUpdated_thenRertunUpdatedEntry(){

        TrainingDiaryEntryDto diaryEntry = TrainingDiaryEntryDto.builder()
                .id(1L)
                .session("10 x 30m")
                .feeling("Gut")
                .build();

        TrainingDiaryEntryDto updatedEntry = TrainingDiaryEntryDto.builder()
                .id(1L)
                .feeling("nicht so Gut.")
                .build();

        this.getTestEntityManager().persist(diaryEntry);

        Mockito.when(this.getTrainingsDiaryEntryRepository().save(diaryEntry)).thenReturn(updatedEntry);

        this.getTrainingDiaryEntryService().updateEntry(updatedEntry);

        assertThat(diaryEntry).hasFieldOrPropertyWithValue("id", 1L);
        assertThat(diaryEntry).hasFieldOrPropertyWithValue("session", "10 x 30m");
        assertThat(diaryEntry).hasFieldOrPropertyWithValue("feeling", "nicht so Gut.");

    }



}