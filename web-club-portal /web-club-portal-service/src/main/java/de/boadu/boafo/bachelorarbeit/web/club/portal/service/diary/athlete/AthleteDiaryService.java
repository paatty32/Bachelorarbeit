package de.boadu.boafo.bachelorarbeit.web.club.portal.service.diary.athlete;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;

import java.util.List;
import java.util.Set;

public interface AthleteDiaryService {
    List<Person> getAthletesByTrainer(Long userId);

    void createAthleteDiary(Long groupId, Long adminId, Long requesterId);

    List<TrainingDiaryEntry> getEntriesFromAthlete(Long clickedPersonId, Long trainerId);

    void addAthleteEntry(Set<Person> trainer, Long athleteId, TrainingDiaryEntry clickedEntry1);
}
