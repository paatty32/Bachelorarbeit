package de.boadu.boafo.bachelorarbeit.web.club.portal.service;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.person.PersonService;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingdiaryentry.TrainingDiaryEntryService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationFacadeImpl implements ApplicationFacade{

    private final PersonService personService;

    private final TrainingDiaryEntryService trainingDiaryEntryService;

    //private final TrainingDiaryService trainingDiaryService;

    @Override
    public void createUser(MutablePerson createPerson, Set<String> clickedRoles) {

        this.getPersonService().createUser(createPerson, clickedRoles);

    }

    @Override
    public List<TrainingDiaryEntry> getTrainingsDiaryEntriesByUser(Long userId) {
        return this.getTrainingDiaryEntryService().getTrainingsDiaryEntriesByUser(userId);
    }


    @Override
    public void addNewTrainingDiaryEntry(long userid, TrainingDiaryEntry newEntry) {

        this.getTrainingDiaryEntryService().addNewTrainingDiaryEntry(userid, newEntry);

    }

    @Override
    public void updateEntry(TrainingDiaryEntry updatedEntry) {

        this.getTrainingDiaryEntryService().updateEntry(updatedEntry);

    }

    @Override
    public void deletEntry(Long currentPersonId, TrainingDiaryEntry selectedEntry) {

        this.getTrainingDiaryEntryService().deleteEntry(currentPersonId, selectedEntry);

    }
}
