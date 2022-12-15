package de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingdiaryentry;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.repository.TrainingsDiaryEntryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.repository.TrainingsDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingDiary.TrainingDiaryService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class TrainingDiaryEntryServiceImpl implements TrainingDiaryEntryService {

    private final TrainingsDiaryEntryRepository trainingsDiaryEntryRepository;

    private final PersonRepository personRepository;

    private final TrainingsDiaryRepository trainingsDiaryRepository;

    private final TrainingDiaryService trainingDiaryService;


    @Override
    public void updateEntry(TrainingDiaryEntry updatedEntry) {

        TrainingDiaryEntryDto updatedEntryDto = (TrainingDiaryEntryDto) updatedEntry;

        this.getTrainingsDiaryEntryRepository().save(updatedEntryDto);

    }



}
