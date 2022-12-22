package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.trainingplan.event.trainingplanform;

import lombok.Data;

public interface TrainingPlanFormEventListener {

    void handleButtonUpdate(TrainingPlanFormEventRequest event);

    void handleButtonDelete(TrainingPlanFormDeleteEntryEventRequest event);

    @Data
    class TrainingPlanFormDeleteEntryEventRequestImpl implements TrainingPlanFormDeleteEntryEventRequest {

        private final Long clickedEntryId;

        @Override
        public Long getDeleteEntryId() {
            return this.getClickedEntryId();
        }
    }
}
