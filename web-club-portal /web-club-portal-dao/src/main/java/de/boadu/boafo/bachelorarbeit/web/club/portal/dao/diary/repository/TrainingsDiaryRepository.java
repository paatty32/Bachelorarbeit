package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingsDiaryRepository extends JpaRepository<TrainingDiaryDto, Long> {



}
