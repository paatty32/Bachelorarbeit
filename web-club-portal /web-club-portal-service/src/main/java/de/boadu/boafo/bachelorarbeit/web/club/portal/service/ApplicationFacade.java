package de.boadu.boafo.bachelorarbeit.web.club.portal.service;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;

import java.util.Set;

public interface ApplicationFacade {

    void createUser(MutablePerson createPerson, Set<String> clickedRoles);

}