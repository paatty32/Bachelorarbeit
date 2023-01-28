package de.boadu.boafo.bachelorarbeit.web.club.portal.service.diary.athlete;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete.AthleteDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete.repository.AthleteDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntryDTO;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.PersonDTO;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AthleteDiaryServiceImpl implements AthleteDiaryService {

    private final AthleteDiaryRepository athleteDiaryRepository;

    private final PersonRepository personRepository;

    @Override
    public List<Person> getAthletesByTrainer(Long userId) {
        List<AthleteDiaryDto> diaryByTrainerId = this.getAthleteDiaryRepository().getDiaryByTrainerId(userId);

        List<PersonDTO> athletesBuffer = new ArrayList<>();

        List<Person> athletes = new ArrayList<>();

        for (AthleteDiaryDto entry: diaryByTrainerId) {

            PersonDTO personById = this.getPersonRepository().findPersonById(entry.getAthleteId());
            athletesBuffer.add(personById);

        }
        
        athletes.addAll(athletesBuffer);

        return athletes;

    }

    @Override
    public void createAthleteDiary(Long groupId, Long adminId, Long requesterId) {

        AthleteDiaryDto athleteDiaryDto = AthleteDiaryDto.builder()
                .groupId(groupId)
                .athleteId(requesterId)
                .trainerId(adminId)
                .build();

        this.getAthleteDiaryRepository().save(athleteDiaryDto);

    }

    @Override
    public List<TrainingDiaryEntry> getEntriesFromAthlete(Long clickedPersonId, Long trainerId) {

        AthleteDiaryDto athleteDiary = this.getAthleteDiaryRepository()
                .getDiaryByTrainerIdAndAthleteId(trainerId, clickedPersonId);

        List<TrainingDiaryEntry> athleteEntries = new ArrayList<>();

        Set<TrainingDiaryEntryDTO> athleteEntriesBuffer = athleteDiary.getAthleteEntries();
        athleteEntries.addAll(athleteEntriesBuffer);

        return athleteEntries;

    }

    @Override
    public void addAthleteEntry(Set<Person> trainer, Long athleteId, TrainingDiaryEntry clickedEntry1) {

        Set<Person> clickedTrainerBuffer = new HashSet<>();
        clickedTrainerBuffer.addAll(trainer);

        for (Person clickedTrainer: clickedTrainerBuffer) {

            Long trainerId = clickedTrainer.getId();

            AthleteDiaryDto diaryByTrainerIdAndAthleteId = this.getAthleteDiaryRepository().getDiaryByTrainerIdAndAthleteId(trainerId, athleteId);
            diaryByTrainerIdAndAthleteId.getAthleteEntries().add((TrainingDiaryEntryDTO) clickedEntry1);

            this.getAthleteDiaryRepository().save(diaryByTrainerIdAndAthleteId);

        }
    }
}
