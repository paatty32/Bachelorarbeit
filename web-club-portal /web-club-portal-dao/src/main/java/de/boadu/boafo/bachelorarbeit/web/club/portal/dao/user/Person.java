package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.user;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userRole_diary_mapping",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "diary_id", referencedColumnName = "id")}
    )
    @MapKeyEnumerated(EnumType.STRING)
    private Map<AppUserRole, Diary> diary;

    @Enumerated(EnumType.STRING)
    private AppUserRole role;

}

