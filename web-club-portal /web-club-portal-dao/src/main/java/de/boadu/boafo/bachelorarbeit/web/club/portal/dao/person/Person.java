package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.trainingsgroup.TrainingsGroup;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Person implements MutablePerson, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    private String name;

    private String surname;

    private String password;

    @ManyToMany
    private List<TrainingsGroup> trainingsGroup;

    //TODO: Nochmal angucken wie das genau funktioniert
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //TODO Was ist das ?
    @JoinTable(name = "userRole_diary_mapping", //Diese Tabelle wird angelegt
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "diary_id", referencedColumnName = "id")}
    )
    @MapKeyEnumerated(EnumType.STRING)
    private Map<AppUserRole, Diary> diary;

    @ElementCollection()
    @Enumerated(EnumType.STRING)
    private List <AppUserRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(AppUserRole.ROLE_ATHLETE.name());

        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.getSurname() + " " + this.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

