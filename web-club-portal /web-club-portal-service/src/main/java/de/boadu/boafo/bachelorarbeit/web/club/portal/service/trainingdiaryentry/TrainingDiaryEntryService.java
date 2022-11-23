package de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingdiaryentry;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryEntry;

import java.util.List;

public interface TrainingDiaryEntryService {

    void addNewTrainingDiaryEntry(long userid, TrainingDiaryEntry newEntry);

    void updateEntry(TrainingDiaryEntry updatedEntry);

    void deleteEntry(Long currentPersonId, TrainingDiaryEntry selectedEntry);

    List<TrainingDiaryEntry> getTrainingsDiaryEntriesByUser(Long userId);
}
