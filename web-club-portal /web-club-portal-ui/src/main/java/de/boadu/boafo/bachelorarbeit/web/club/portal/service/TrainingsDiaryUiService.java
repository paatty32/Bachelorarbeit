package de.boadu.boafo.bachelorarbeit.web.club.portal.service;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntry;

import java.util.List;

public interface TrainingsDiaryUiService {

    List<TrainingDiaryEntry> getTrainingsDiaryEntryiesByUser(Long userId);

    void addNewTrainingDiaryEntry(long userId, TrainingDiaryEntry newEntry);

    void updateEntry(TrainingDiaryEntry updatedEntry);

    void deleteEntry(Long currentPersonId, TrainingDiaryEntry selectedEntry);
}
