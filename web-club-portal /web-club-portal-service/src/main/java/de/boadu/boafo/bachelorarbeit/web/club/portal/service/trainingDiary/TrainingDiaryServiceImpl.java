package de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingDiary;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.*;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.repository.TrainingsDiaryEntryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.repository.TrainingsDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.DiaryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class TrainingDiaryServiceImpl implements TrainingDiaryService{

    private final TrainingsDiaryRepository trainingsDiaryRepository;

    private final TrainingsDiaryEntryRepository trainingsDiaryEntryRepository;

    @Override
    public TrainingDiary getTrainingsDiaryByUser(DiaryId userId) {

        TrainingDiaryDto trainingDiaryById = this.getTrainingsDiaryRepository().findTrainingDiaryById(userId);

        return trainingDiaryById;
    }

    @Override
    public void addNewTrainingDiaryEntry(long userId, TrainingDiaryEntry newEntry) {

        DiaryId trainingDiaryIdByUser = buildTrainingDiaryId(userId);

        TrainingDiary diary = this.getTrainingsDiaryByUser(trainingDiaryIdByUser);

        diary.getEntry().add((TrainingDiaryEntryDto) newEntry);

        this.getTrainingsDiaryRepository().save((TrainingDiaryDto) diary);
    }



    @Override
    public List<TrainingDiaryEntry> getTrainingsDiaryEntriesByUser(Long userId) {

        List<TrainingDiaryEntry> trainingDiaryEntries = new ArrayList<>();

        DiaryId trainingDiaryIdByUser = this.buildTrainingDiaryId(userId);

        TrainingDiary trainingsDiaryByUser = this.getTrainingsDiaryByUser(trainingDiaryIdByUser);

        List<TrainingDiaryEntryDto> entry = trainingsDiaryByUser.getEntry();

        trainingDiaryEntries.addAll(entry);

        return trainingDiaryEntries;

    }

    @Override
    public void deleteEntry(Long currentPersonId, Long selectedEntryId) {

        DiaryId trainingDiaryIdByUser = this.buildTrainingDiaryId(currentPersonId);

        TrainingDiary diary = this.getTrainingsDiaryByUser(trainingDiaryIdByUser);

        TrainingDiaryEntryDto entryById = this.getTrainingsDiaryEntryRepository().findEntryById(selectedEntryId);

        int entryIndex = diary.getEntry().indexOf(entryById);

        if(entryIndex != -1) {

            diary.getEntry().remove(entryIndex);

        }
        this.getTrainingsDiaryRepository().save((TrainingDiaryDto) diary);
    }

    private DiaryId buildTrainingDiaryId(long userId) {
        return DiaryId.builder()
                .userId(userId)
                .diaryType(DiaryType.TRAINING)
                .build();
    }

}
