package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component;

import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.event.TrainingsDiaryEventListener;

public interface AbstractObserver<T>{

    void addEventListeners(T listener);

}
