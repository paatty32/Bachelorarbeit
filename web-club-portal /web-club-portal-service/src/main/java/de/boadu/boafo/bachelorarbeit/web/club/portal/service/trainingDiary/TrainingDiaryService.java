package de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingDiary;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiary;

public interface TrainingDiaryService {
    TrainingDiary getTrainingsDiaryByUser(Long userId);


}
