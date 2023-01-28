package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.athlete.events;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;

public interface AthleteDiaryGridEventRequest {

    Person getClickedPerson();

    static AthleteDiaryGridEventRequestImpl getInstance(Person person){

        return new AthleteDiaryGridEventRequestImpl(person);

    }
}
