package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition;

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
public class CompetitionDiaryEntryDto implements CompetitionDiaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String place;
    private String dicipline;
    private String resaults;
    private String feeling;

}
