package de.boadu.boafo.bachelorarbeit.web.club.portal.service.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.DiaryId;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete.AthleteDiary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete.AthleteDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.athlete.repository.AthleteDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.CompetitionDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.repository.CompetitionDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.repository.TrainingsDiaryRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.TrainingPlan;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.TrainingPlanDTO;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.trainingplan.repository.TrainingPlanRepository;
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

    private final AthleteDiaryRepository athleteDiaryRepository;

    private final TrainingPlanRepository trainingPlanRepository;

    @Override
    public Person createUser(MutablePerson createPerson, Set<String> clickedRoles) {

        Set<AppUserRole> appUserRoles = this.initializeUserRoles(clickedRoles);

        createPerson.setRoles(appUserRoles);

        Person personToCreate = (Person) createPerson;

        Person createdPerson = this.getPersonRepository().save(personToCreate);

        this.initializeUserDiares(createdPerson, clickedRoles);

        return createdPerson;

    }

    private Map<DiaryType, Diary> initializeUserDiares(Person createdPerson, Set<String> clickedRoles) {

        Map<DiaryType, Diary> personDiaries = new HashMap<>();

        Long createdPersonId = createdPerson.getId();

        DiaryId trainingPlanDiaryId = DiaryId.builder()
                .userId(createdPersonId)
                .diaryType(DiaryType.TRAININGPLAN)
                .build();

        TrainingPlan trainingPlanDiary = new TrainingPlanDTO(trainingPlanDiaryId);
        this.getTrainingPlanRepository().save((TrainingPlanDTO) trainingPlanDiary);

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
                    this.getTrainingsDiaryRepository().save(trainingDiary);

                    CompetitionDiaryDto competitionDiary = new CompetitionDiaryDto(competitionDiaryId);
                    this.getCompetitionDiaryRepository().save(competitionDiary);

                    break;

                case "Trainer":
                    DiaryId athelteDiaryId = DiaryId.builder()
                            .userId(createdPersonId)
                            .diaryType(DiaryType.ATHLETE)
                            .build();


                    AthleteDiary athleteDiary = new AthleteDiaryDto(athelteDiaryId);
                    this.getAthleteDiaryRepository().save((AthleteDiaryDto) athleteDiary);
                    break;

                case "Eltern":
                    //TODO
                    break;
            }

        }

        return personDiaries;
    }

    private Set<AppUserRole> initializeUserRoles(Set<String> clickedRoles) {

        Set<AppUserRole> roles = new LinkedHashSet<>();


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
