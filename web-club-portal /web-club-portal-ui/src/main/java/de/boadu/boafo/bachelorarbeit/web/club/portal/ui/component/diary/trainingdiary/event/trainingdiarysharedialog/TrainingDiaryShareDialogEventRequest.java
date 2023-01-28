package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingdiary.event.trainingdiarysharedialog;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import org.springframework.security.core.parameters.P;

import java.util.Set;

public interface TrainingDiaryShareDialogEventRequest {

    Set<Person> getTrainer();

    static TrainingDiaryShareDialogEventRequestImpl getInstanceOf(Set<Person> trainer){
        return new TrainingDiaryShareDialogEventRequestImpl(trainer);
    }
}
