package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class CompetitionDiary extends Diary {

    private String satisfaction;
    private String result;
    private Date date;
    private String sportDiscipline;
    private String location;

}
