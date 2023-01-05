package de.boadu.boafo.bachelorarbeit.web.club.portal.service;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.GroupRequest;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.MutableGroupRequest;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.MutableGroup;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.Group;

import java.util.List;

public interface GroupUiService {

    Group createTrainingGroup(MutableGroup newGroupToCreate);

    List<Group> getTrainingGroups();

    void addGroupRequest(Long groupId, MutableGroupRequest request);

    List<GroupRequest> getGroupRequestByTrainer(Long userId);

    Group getTrainingGroupById(Long groupId);

    void deleteGroupRequestById(Long id, Long groupId);

}
