package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary;

import java.time.LocalDate;

public interface TrainingDiaryEntry {

    public Long getId();
    public LocalDate getDate();
    public String getSession();
    public String getFeeling();
    public Boolean getIsShared();
}
