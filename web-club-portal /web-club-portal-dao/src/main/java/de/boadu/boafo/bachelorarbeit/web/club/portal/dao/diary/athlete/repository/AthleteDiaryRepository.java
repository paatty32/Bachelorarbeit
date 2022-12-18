package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.DiaryId;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete.AthleteDiaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteDiaryRepository extends JpaRepository<AthleteDiaryDto, DiaryId> {

    AthleteDiaryDto save(AthleteDiaryDto diary);

}
