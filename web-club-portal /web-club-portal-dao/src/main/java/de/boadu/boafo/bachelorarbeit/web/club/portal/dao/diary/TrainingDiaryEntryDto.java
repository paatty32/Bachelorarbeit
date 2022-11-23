package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary;


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

}
