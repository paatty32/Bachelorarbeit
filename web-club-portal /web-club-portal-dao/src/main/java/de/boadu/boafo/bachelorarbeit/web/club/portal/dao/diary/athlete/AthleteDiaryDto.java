package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.DiaryId;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.PersonDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AthleteDiaryDto extends Diary implements AthleteDiary, MutableAthleteDiary{

    public AthleteDiaryDto (DiaryId id){

        super(id);

    }

    @OneToMany
    private List<PersonDTO> athletes;




}
