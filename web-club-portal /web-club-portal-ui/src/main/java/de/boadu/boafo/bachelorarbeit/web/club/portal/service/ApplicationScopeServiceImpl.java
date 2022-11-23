package de.boadu.boafo.bachelorarbeit.web.club.portal.service;

import com.vaadin.flow.spring.annotation.SpringComponent;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@SpringComponent
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationScopeServiceImpl implements RegistrationUiService, TrainingsDiaryUiService{

    private final ApplicationFacade applicationFacade;

    @Override
    public void createUser(MutablePerson createPerson, Set<String> clickedRoles) {

        this.getApplicationFacade().createUser(createPerson, clickedRoles);

    }

    @Override
    public List<TrainingDiaryEntry> getTrainingsDiaryEntryiesByUser(Long userId) {

        List<TrainingDiaryEntry> trainingsDiaryEntriesByUser = this.getApplicationFacade().getTrainingsDiaryEntriesByUser(userId);

        return trainingsDiaryEntriesByUser;

    }

    @Override
    public void addNewTrainingDiaryEntry(long userId, TrainingDiaryEntry newEntry) {

        this.getApplicationFacade().addNewTrainingDiaryEntry(userId, newEntry);

    }

    @Override
    public void updateEntry(TrainingDiaryEntry updatedEntry) {

        this.getApplicationFacade().updateEntry(updatedEntry);

    }

    @Override
    public void deleteEntry(Long currentPersonId, TrainingDiaryEntry selectedEntry) {

        this.getApplicationFacade().deletEntry(currentPersonId, selectedEntry);

    }
}
