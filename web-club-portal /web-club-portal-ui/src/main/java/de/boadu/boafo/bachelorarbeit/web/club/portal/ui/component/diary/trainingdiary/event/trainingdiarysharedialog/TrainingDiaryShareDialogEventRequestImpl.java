package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingdiary.event.trainingdiarysharedialog;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import lombok.Data;

import java.util.Set;

@Data
public class TrainingDiaryShareDialogEventRequestImpl implements TrainingDiaryShareDialogEventRequest{

    private final Set<Person> clickedTrainer;

    @Override
    public Set<Person> getTrainer() {
        return this.getClickedTrainer();
    }
}
