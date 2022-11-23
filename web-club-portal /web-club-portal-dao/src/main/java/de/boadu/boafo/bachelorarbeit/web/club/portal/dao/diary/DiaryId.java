package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryId implements Serializable {

    private Long userId;

    private AppUserRole userRole;

}
