package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.athlete.events;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.Person;
import lombok.Data;

@Data
public class AthleteDiaryGridEventRequestImpl implements AthleteDiaryGridEventRequest {

    private final Person person;

    @Override
    public Person getClickedPerson() {
        return this.getPerson();
    }
}
