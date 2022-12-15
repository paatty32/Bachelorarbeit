package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TrainingDiaryEntryDto implements TrainingDiaryEntry, MutableTrainingDiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String session;
    private String feeling;
    private Boolean isShared;

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof TrainingDiaryEntryDto other){

            return this.getId() == other.getId();

        } else return false;

    }
}
