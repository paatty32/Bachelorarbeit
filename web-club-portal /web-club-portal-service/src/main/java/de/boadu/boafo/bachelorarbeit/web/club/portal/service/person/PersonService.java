package de.boadu.boafo.bachelorarbeit.web.club.portal.service.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.PersonDTO;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.MutableGroup;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.Group;

import java.util.Set;

public interface PersonService {

    PersonDTO createUser(MutablePerson createPerson, Set<String> clickedRoles);

    void addNewGroupToUser(Long userId, MutableGroup newTrainingGroup);

    Set<Group> getUserGroups(Long userId);

    Set<Person> getUserTrainer(Long userId);
}
