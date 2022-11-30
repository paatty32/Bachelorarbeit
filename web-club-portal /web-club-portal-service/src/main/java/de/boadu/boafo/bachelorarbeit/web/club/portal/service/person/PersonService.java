package de.boadu.boafo.bachelorarbeit.web.club.portal.service.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;

import java.util.Set;

public interface PersonService {

    Person createUser(MutablePerson createPerson, Set<String> clickedRoles);

}
