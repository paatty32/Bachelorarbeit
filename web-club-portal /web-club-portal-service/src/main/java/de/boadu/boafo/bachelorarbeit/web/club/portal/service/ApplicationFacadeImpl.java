package de.boadu.boafo.bachelorarbeit.web.club.portal.service;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.CompetitionDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.CompetitionDiaryEntryDto;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.competition.MutableCompetitionDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.diary.training.TrainingDiaryEntry;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.diary.competitiondiary.CompetitionDiaryService;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.diary.competitiondiaryentry.CompetitionDiaryEntryService;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.person.PersonService;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingDiary.TrainingDiaryService;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.trainingdiaryentry.TrainingDiaryEntryService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationFacadeImpl implements ApplicationFacade{

    private final PersonService personService;

    private final TrainingDiaryEntryService trainingDiaryEntryService;

    private final CompetitionDiaryEntryService competitionDiaryEntryService;

    private final CompetitionDiaryService competitionDiaryService;

    private final TrainingDiaryService trainingDiaryService;

    @Override
    public void createUser(MutablePerson createPerson, Set<String> clickedRoles) {

        this.getPersonService().createUser(createPerson, clickedRoles);

    }

    @Override
    public List<TrainingDiaryEntry> getTrainingsDiaryEntriesByUser(Long userId) {
        return this.getTrainingDiaryService().getTrainingsDiaryEntriesByUser(userId);
    }


    @Override
    public void addNewTrainingDiaryEntry(long userid, TrainingDiaryEntry newEntry) {

        this.getTrainingDiaryService().addNewTrainingDiaryEntry(userid, newEntry);

    }

    @Override
    public void updateEntry(TrainingDiaryEntry updatedEntry) {

        this.getTrainingDiaryEntryService().updateEntry(updatedEntry);

    }

    @Override
    public void deleteTrainingEntry(Long userId, Long clickedEntryId) {

        this.getTrainingDiaryService().deleteEntry(userId, clickedEntryId);

    }

    @Override
    public void addNewCompetitionDiaryEntry(Long userId, MutableCompetitionDiaryEntry newEntry) {

        this.getCompetitionDiaryService().addNewCompetitionDiaryEntry(userId, newEntry);

    }

    @Override
    public List<CompetitionDiaryEntry> getCompetitionDiaryEntriesByUser(Long userId) {

        List<CompetitionDiaryEntry> competitionDiaryEntriesByUser = this.getCompetitionDiaryService().getCompetitionDiaryEntriesByUser(userId);

        return competitionDiaryEntriesByUser;

    }

    @Override
    public CompetitionDiaryEntryDto updateCompetitionEntry(MutableCompetitionDiaryEntry updatedEntry) {

        CompetitionDiaryEntryDto updatedCompetitionEntry = this.getCompetitionDiaryEntryService().updateCompetitionEntry(updatedEntry);

        return updatedCompetitionEntry;

    }

    @Override
    public void deleteEntry(Long userId, Long clickedEntryId) {

        this.getCompetitionDiaryService().deleteEntry(userId, clickedEntryId);
    }
}
