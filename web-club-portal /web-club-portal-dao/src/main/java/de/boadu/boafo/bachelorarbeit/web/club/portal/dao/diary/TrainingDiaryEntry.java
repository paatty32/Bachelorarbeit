package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary;

import java.sql.Date;

public interface TrainingDiaryEntry {

    public Date getDate();
    public String getSession();
    public String getFeeling();
    public Boolean getIsShared();
}
