package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.trainingplan.TrainingPlan;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;

import java.util.List;

public interface TrainingDiary {

    public String getDisciplin();
    public Person getTrainer();
    public List<TrainingDiaryEntryDto> getEntry();
    public List<TrainingPlan> getTrainingPlan();

    public int getEntryIndex(Long id);


}
