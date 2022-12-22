package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TrainingPlanEntryDTO implements TrainingPlanEntry, MutableTrainingPlanEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String session;
    private LocalDate date;
    private String athlete;

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof TrainingPlanEntryDTO other){

            return this.getId() == other.getId();

        }

        return false;
    }
}
