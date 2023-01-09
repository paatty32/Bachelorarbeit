package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.GroupDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonDTO implements MutablePerson, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    private String name;

    private String surname;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<GroupDTO> trainingsGroup;

    /*
    //TODO: Nochmal angucken wie das genau funktioniert
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //TODO Was ist das ?
    @JoinTable(name = "userRole_diary_mapping", //Diese Tabelle wird angelegt
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "diary_id", referencedColumnName = "id")}
    )
    @MapKeyEnumerated(EnumType.STRING)
    private Map<DiaryType, Diary> diary;

     */

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<AppUserRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (AppUserRole role : this.roles) {

            authorities.add(new SimpleGrantedAuthority(role.name()));

        }

        return authorities;
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
