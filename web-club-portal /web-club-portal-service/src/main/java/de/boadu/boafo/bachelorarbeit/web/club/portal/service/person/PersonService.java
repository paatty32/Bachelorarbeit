package de.boadu.boafo.bachelorarbeit.web.club.portal.service.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;

import java.util.Set;

public interface PersonService {

    void createUser(MutablePerson createPerson, Set<String> clickedRoles);

}
