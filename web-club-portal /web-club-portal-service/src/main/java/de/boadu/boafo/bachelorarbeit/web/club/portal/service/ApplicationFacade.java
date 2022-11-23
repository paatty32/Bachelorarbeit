package de.boadu.boafo.bachelorarbeit.web.club.portal.service;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;

import java.util.List;
import java.util.Set;

public interface ApplicationFacade {

    void createUser(MutablePerson createPerson, Set<String> clickedRoles);

    List<TrainingDiaryEntry> getTrainingsDiaryEntriesByUser(Long userId);

    void addNewTrainingDiaryEntry(long userId, TrainingDiaryEntry newEntry);

    void updateEntry(TrainingDiaryEntry updatedEntry);

    void deletEntry(Long currentPersonId, TrainingDiaryEntry selectedEntry);
}
