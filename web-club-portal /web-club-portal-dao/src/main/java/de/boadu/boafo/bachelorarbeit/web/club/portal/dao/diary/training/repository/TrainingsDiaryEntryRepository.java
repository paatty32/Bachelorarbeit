package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingsDiaryEntryRepository extends JpaRepository<TrainingDiaryEntryDto, Long> {

    TrainingDiaryEntryDto save(TrainingDiaryEntryDto diaryEntryDto);

}
