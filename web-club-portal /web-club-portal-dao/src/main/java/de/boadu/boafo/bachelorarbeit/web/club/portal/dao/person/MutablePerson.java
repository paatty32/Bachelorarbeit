package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;

import java.util.List;
import java.util.Map;

public interface MutablePerson {

    void setName(String name);
    void setSurname(String name);
    void setPassword(String password);
    void setRoles(List<AppUserRole> roles);
    void setDiary(Map<AppUserRole, Diary> diary);

}
