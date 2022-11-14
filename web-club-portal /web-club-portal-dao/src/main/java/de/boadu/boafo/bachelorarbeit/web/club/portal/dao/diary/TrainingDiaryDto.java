package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.trainingplan.TrainingPlan;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TrainingDiaryDto extends Diary implements TrainingDiary{

    private String disciplin;

    @ManyToOne
    private Person trainer;

    @OneToMany
    private List<TrainingDiaryEntryDto> entry;

    @ManyToMany
    private List<TrainingPlan> trainingPlan;
}
