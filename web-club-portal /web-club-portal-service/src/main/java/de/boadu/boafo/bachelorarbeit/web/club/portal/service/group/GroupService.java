package de.boadu.boafo.bachelorarbeit.web.club.portal.service.group;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.GroupRequest;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.MutableGroupRequest;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.MutableGroup;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.Group;

import java.util.List;

public interface GroupService {
    Group createTraininGroup(MutableGroup newGroupToCreate);

    List<Group> getAllTrainingGroups();

    void addGroupRequest(Long groupId, MutableGroupRequest request);

    List<GroupRequest> getGroupRequestByAdmin(Long adminId);

    Group getTrainingGroupById(Long groupId);

    void deleteGroupequestById(Long id, Long groupId);

    List<Group> getTrainingGroupsByAdmin(Long userId);
}
