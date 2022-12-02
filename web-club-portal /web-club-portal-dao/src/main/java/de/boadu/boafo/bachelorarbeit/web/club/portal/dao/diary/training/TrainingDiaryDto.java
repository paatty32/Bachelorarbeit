package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
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
public class TrainingDiaryDto extends Diary implements TrainingDiary {

    private String disciplin;

    @ManyToOne
    private Person trainer;

    /*TODO: Damit wird sicher gestellt, dass auch in der Tabelle der Eintrag gelöscht wird und nicht nur in der Referenztabelel*/
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingDiaryEntryDto> entry;

    @ManyToMany
    private List<TrainingPlan> trainingPlan;

    @Override
    public int getEntryIndex(Long id) {

        int entryIndex = 0;

        if(this.getEntry().size() != 0){

            for (int index = 0; index < this.getEntry().size(); index++ ) {

                if(this.getEntry().get(index).getId().longValue() == id){

                    entryIndex = index;

                    return entryIndex;

                }

            }

        }

        return 0;
    }
}
