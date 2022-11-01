package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.trainingplan.TrainingPlan;

import java.util.List;

public interface TrainingDiary {

    public String getDisciplin();
    public String getTrainer();
    public List<TrainingDiaryEntryDto> getEntry();
    public List<TrainingPlan> getTrainingPlan();


}
