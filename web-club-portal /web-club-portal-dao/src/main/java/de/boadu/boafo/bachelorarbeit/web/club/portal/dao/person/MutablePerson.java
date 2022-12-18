package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;

import java.util.List;
import java.util.Set;

public interface MutablePerson {

    void setName(String name);
    void setSurname(String name);
    void setPassword(String password);
    void setRoles(Set<AppUserRole> roles);

}
