package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.DiaryType;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.trainingsgroup.TrainingsGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Diary {

    @EmbeddedId
    private DiaryId id;

}
