package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;

import java.util.List;

public interface MutableAthleteDiary {

    void setAthletes(List<Person> athletes);
}
