package de.boadu.boafo.bachelorarbeit.web.club.portal.service.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.DiaryId;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.CompetitionDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.repository.CompetitionDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.repository.TrainingsDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.DiaryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    private final TrainingsDiaryRepository trainingsDiaryRepository;

    private final CompetitionDiaryRepository competitionDiaryRepository;

    @Override
    public Person createUser(MutablePerson createPerson, Set<String> clickedRoles) {

        List<AppUserRole> appUserRoles = this.initializeUserRoles(clickedRoles);

        createPerson.setRoles(appUserRoles);

        Person personToCreate = (Person) createPerson;

        Person createdPerson = this.getPersonRepository().save(personToCreate);

        this.initializeUserDiares(createdPerson, clickedRoles);

        return createdPerson;

    }

    private Map<DiaryType, Diary> initializeUserDiares(Person createdPerson, Set<String> clickedRoles) {

        Map<DiaryType, Diary> personDiaries = new HashMap<>();

        Long createdPersonId = createdPerson.getId();

        for (String role: clickedRoles) {

            switch (role){

                case "Athlet":

                    DiaryId trainingDiaryId = DiaryId.builder()
                            .userId(createdPersonId)
                            .diaryType(DiaryType.TRAINING)
                            .build();

                    DiaryId competitionDiaryId = DiaryId.builder()
                            .userId(createdPersonId)
                            .diaryType(DiaryType.COMPETITION)
                            .build();

                    TrainingDiaryDto trainingDiary = new TrainingDiaryDto(trainingDiaryId);

                    CompetitionDiaryDto competitionDiary = new CompetitionDiaryDto(competitionDiaryId);

                    this.getTrainingsDiaryRepository().save(trainingDiary);

                    this.getCompetitionDiaryRepository().save(competitionDiary);
                    break;

                case "Trainer":
                    //TODO
                    break;

                case "Eltern":
                    //TODO
                    break;
            }

        }

        return personDiaries;
    }

    private List<AppUserRole> initializeUserRoles(Set<String> clickedRoles) {

        List<AppUserRole> roles = new ArrayList<>();


        for (String role: clickedRoles){

            switch (role){
                case "Athlet":
                    roles.add(AppUserRole.ROLE_ATHLETE);
                    break;

                case "Trainer":
                    roles.add(AppUserRole.ROLE_TRAINER);
                    break;

                case "Eltern":
                    //TODO
                    break;
            }
        }
        return roles;
    }
}
