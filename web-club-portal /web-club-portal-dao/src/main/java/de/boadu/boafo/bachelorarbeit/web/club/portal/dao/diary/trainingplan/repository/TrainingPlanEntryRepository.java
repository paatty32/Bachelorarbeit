package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.TrainingPlanEntryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingPlanEntryRepository extends JpaRepository<TrainingPlanEntryDTO, Long> {

    TrainingPlanEntryDTO save(TrainingPlanEntryDTO entry);

    TrainingPlanEntryDTO findEntryById(Long id);

}
