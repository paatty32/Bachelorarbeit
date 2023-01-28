package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntryDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@IdClass(AthleteDiaryId.class)
public class AthleteDiaryDto implements AthleteDiary, MutableAthleteDiary{

    @Id
    private Long trainerId;

    @Id
    private Long athleteId;

    @Id
    private Long groupId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<TrainingDiaryEntryDTO> athleteEntries;

    final int SEED =23; //random Zahl
    final int ODD_PRIME_NUMBER = 37;


}
