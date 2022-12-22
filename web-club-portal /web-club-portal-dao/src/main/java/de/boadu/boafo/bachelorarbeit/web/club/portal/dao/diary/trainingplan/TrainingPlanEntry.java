package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan;

import java.time.LocalDate;

public interface TrainingPlanEntry {

    Long getId();

    String getSession();

    LocalDate getDate();

    String getAthlete();

}
