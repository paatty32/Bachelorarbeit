package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @Id
    @Enumerated(EnumType.STRING)
    private AppUserRole role;

    /*
    @Id
    @ManyToOne
    private Person person;
    @ManyToOne
    private TrainingsGroup trainingsGroup;*/

}
