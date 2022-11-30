package de.boadu.boafo.bachelorarbeit.web.club.portal.service.person;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.TrainingDiaryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.repository.PersonRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
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

    @Override
    public Person createUser(MutablePerson createPerson, Set<String> clickedRoles) {

        Map<AppUserRole, Diary> userDiary = this.initializeUserDiares(clickedRoles);

        List<AppUserRole> appUserRoles = this.initializeUserRoles(clickedRoles);

        createPerson.setDiary(userDiary);
        createPerson.setRoles(appUserRoles);

        Person personToCreate = (Person) createPerson;

        Person createdPerson = this.getPersonRepository().save(personToCreate);

        return createdPerson;

    }

    private Map<AppUserRole, Diary> initializeUserDiares(Set<String> clickedRoles) {

        Map<AppUserRole, Diary> personDiaries = new HashMap<>();

        for (String role: clickedRoles) {

            switch (role){

                case "Athlet":

                    TrainingDiaryDto trainingDiary = TrainingDiaryDto.builder().build();

                    personDiaries.put(AppUserRole.ROLE_ATHLETE, trainingDiary);
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
