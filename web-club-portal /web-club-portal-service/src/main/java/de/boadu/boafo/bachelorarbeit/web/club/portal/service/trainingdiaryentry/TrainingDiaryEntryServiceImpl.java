package de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingdiaryentry;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.repository.TrainingsDiaryEntryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingDiary.TrainingDiaryService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class TrainingDiaryEntryServiceImpl implements TrainingDiaryEntryService {

    private final TrainingsDiaryEntryRepository trainingsDiaryEntryRepository;

    private final PersonRepository personRepository;

    private final TrainingDiaryService trainingDiaryService;

    @Override
    public List<TrainingDiaryEntry> getTrainingsDiaryEntriesByUser(Long userId) {

        List<TrainingDiaryEntry> trainingDiaryEntries = new ArrayList<>();

        TrainingDiary trainingsDiaryByUser = this.getTrainingDiaryService().getTrainingsDiaryByUser(userId);

        List<TrainingDiaryEntryDto> entry = trainingsDiaryByUser.getEntry();

        trainingDiaryEntries.addAll(entry);

        return trainingDiaryEntries;

    }


    @Override
    public void addNewTrainingDiaryEntry(long userId, TrainingDiaryEntry newEntry) {

        Person personById = this.getPersonRepository().findPersonById(userId);

        TrainingDiary diary = (TrainingDiary) personById.getDiary().get(AppUserRole.ROLE_ATHLETE);
        diary.getEntry().add((TrainingDiaryEntryDto) newEntry);

        this.getPersonRepository().save(personById);

    }

    @Override
    public void updateEntry(TrainingDiaryEntry updatedEntry) {

        TrainingDiaryEntryDto updatedEntryDto = (TrainingDiaryEntryDto) updatedEntry;

        this.getTrainingsDiaryEntryRepository().save(updatedEntryDto);

    }

    @Override
    public void deleteEntry(Long currentPersonId, TrainingDiaryEntry selectedEntry) {

        Person personById = this.getPersonRepository().findPersonById(currentPersonId);

        TrainingDiary diary = (TrainingDiary) personById.getDiary().get(AppUserRole.ROLE_ATHLETE);

        Long selectedEntryId = selectedEntry.getId();

        int entryIndex = diary.getEntryIndex(selectedEntryId);

        diary.getEntry().remove(entryIndex);

        this.getPersonRepository().save(personById);

    }


}
