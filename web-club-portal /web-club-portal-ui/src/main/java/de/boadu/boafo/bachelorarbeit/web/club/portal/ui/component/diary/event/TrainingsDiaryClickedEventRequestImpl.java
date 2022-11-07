package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.event;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntry;
import lombok.Data;

@Data
public class TrainingsDiaryClickedEventRequestImpl implements TrainingsDiaryClickedEventRequest {

    private final TrainingDiaryEntry trainingDiaryEntry;

    @Override
    public TrainingDiaryEntry getEntry() {
        return this.getTrainingDiaryEntry();
    }
}
