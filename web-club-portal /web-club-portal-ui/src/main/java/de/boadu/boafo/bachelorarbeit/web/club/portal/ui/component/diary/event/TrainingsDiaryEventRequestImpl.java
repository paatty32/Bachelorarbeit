package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.event;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntry;
import lombok.Data;
import lombok.NonNull;

@Data
public class TrainingsDiaryEventRequestImpl implements TrainingsDiaryEventRequest {

    private final TrainingDiaryEntry trainingDiaryEntry;

    @Override
    public TrainingDiaryEntry getEntry() {
        return this.getTrainingDiaryEntry();
    }
}
