package de.boadu.boafo.bachelorarbeit.web.club.portal;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.Diary;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.roles.AppUserRole;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.user.Person;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.user.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class WebClubPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClubPortalApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PersonRepository personRepository){

		return args -> {

			Diary diary = new Diary(2L, AppUserRole.ROLE_ATHLETE);
			Map<AppUserRole, Diary> diaryMap = new HashMap<>();

			diaryMap.put(AppUserRole.ROLE_ATHLETE, diary);

			Person pat = new Person(1L,"Patrick", "Boadu Boafo", AppUserRole.ROLE_ATHLETE, diaryMap);

			personRepository.save(pat);

			System.out.println(personRepository.findPersonByName("Patrick").getName());
			System.out.println(personRepository.findPersonByName("Patrick").getDiary().get(AppUserRole.ROLE_ATHLETE).getRole().toString());
		};
	}

}


