package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.trainingsgroup;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class TrainingsGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
