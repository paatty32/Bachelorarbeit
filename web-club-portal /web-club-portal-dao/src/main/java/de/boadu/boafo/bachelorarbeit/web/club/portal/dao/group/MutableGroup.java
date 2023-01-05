package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group;

public interface MutableGroup {

    void setId(Long id);

    void setName(String name);

    void setTrainer(String trainerName);

    void setDescription(String description);

    void setAdminId(Long id);

}
