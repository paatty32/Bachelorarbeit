package de.boadu.boafo.bachelorarbeit.web.club.portal.service;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.CompetitionDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.CompetitionDiaryEntryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.MutableCompetitionDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;

import java.util.List;
import java.util.Set;

public interface ApplicationFacade {

    void createUser(MutablePerson createPerson, Set<String> clickedRoles);

    List<TrainingDiaryEntry> getTrainingsDiaryEntriesByUser(Long userId);

    void addNewTrainingDiaryEntry(long userId, TrainingDiaryEntry newEntry);

    void updateEntry(TrainingDiaryEntry updatedEntry);

    void deleteTrainingEntry(Long currentPersonId, Long selectedEntry);

    void addNewCompetitionDiaryEntry(Long userId, MutableCompetitionDiaryEntry newEntry);

    List<CompetitionDiaryEntry> getCompetitionDiaryEntriesByUser(Long userId);

    CompetitionDiaryEntryDto updateCompetitionEntry(MutableCompetitionDiaryEntry updatedEntry);

    void deleteEntry(Long userId, Long entry);
}
