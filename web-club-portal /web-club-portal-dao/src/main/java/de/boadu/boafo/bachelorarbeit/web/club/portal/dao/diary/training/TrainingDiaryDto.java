package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.DiaryId;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.DiaryType;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.trainingplan.TrainingPlan;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import lombok.*;
import org.aspectj.weaver.tools.ISupportsMessageContext;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TrainingDiaryDto extends Diary implements TrainingDiary, MutableTrainingDiary {

    public TrainingDiaryDto(DiaryId id){
        super(id);
    }

    private String disciplin;

    @ManyToOne
    private Person trainer;

    /*TODO: Damit wird sicher gestellt, dass auch in der Tabelle der Eintrag gelöscht wird und nicht nur in der Referenztabelel*/
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingDiaryEntryDto> entry;

    @ManyToMany
    private List<TrainingPlan> trainingPlan;

}
