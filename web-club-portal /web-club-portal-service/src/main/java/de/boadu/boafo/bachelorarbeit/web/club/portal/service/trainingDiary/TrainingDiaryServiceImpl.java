package de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingDiary;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.*;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class TrainingDiaryServiceImpl implements TrainingDiaryService{

    private final PersonRepository personRepository;

    @Override
    public TrainingDiary getTrainingsDiaryByUser(Long userId) {

        Person personById = this.getPersonRepository().findPersonById(userId);

        Map<AppUserRole, Diary> diary = personById.getDiary();
        TrainingDiary personTrainingDiary = (TrainingDiary) diary.get(AppUserRole.ROLE_ATHLETE);

        return personTrainingDiary;
    }



}
