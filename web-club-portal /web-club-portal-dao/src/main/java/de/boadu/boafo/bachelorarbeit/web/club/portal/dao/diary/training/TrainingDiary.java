package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.TrainingPlanDTO;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;

import java.util.List;

public interface TrainingDiary {

     String getDisciplin();
     Person getTrainer();
     List<TrainingDiaryEntryDTO> getEntry();
     List<TrainingPlanDTO> getTrainingPlan();


}
