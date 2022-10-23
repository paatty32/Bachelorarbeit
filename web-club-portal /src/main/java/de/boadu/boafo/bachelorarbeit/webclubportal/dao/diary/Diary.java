package de.boadu.boafo.bachelorarbeit.webclubportal.dao.diary;

import de.boadu.boafo.bachelorarbeit.webclubportal.dao.roles.AppUserRole;
import de.boadu.boafo.bachelorarbeit.webclubportal.dao.trainingsgroup.TrainingsGroup;
import de.boadu.boafo.bachelorarbeit.webclubportal.dao.user.Person;
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

