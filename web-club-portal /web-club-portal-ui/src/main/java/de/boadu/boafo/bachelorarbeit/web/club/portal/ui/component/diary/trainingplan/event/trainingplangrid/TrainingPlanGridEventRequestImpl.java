package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan.event.trainingplangrid;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.TrainingPlanEntry;
import lombok.Data;

@Data
public class TrainingPlanGridEventRequestImpl implements TrainingPlanGridEventRequest {

    private final TrainingPlanEntry clickedEntry;

    @Override
    public TrainingPlanEntry getTrainingPlanEntry() {
        return this.getClickedEntry();
    }
}
