package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CompetitionDiaryDto extends Diary implements CompetitionDiary {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompetitionDiaryEntryDto> entry;

}
