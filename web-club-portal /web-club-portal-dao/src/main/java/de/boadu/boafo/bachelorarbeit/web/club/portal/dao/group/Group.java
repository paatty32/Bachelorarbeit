package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group;

import java.util.Set;

public interface Group {

    Long getId();
    String getName();

    String getTrainer();

    String getDescription();

    Long getAdminId();

    Set<GroupRequestsDTO> getRequests();

}
