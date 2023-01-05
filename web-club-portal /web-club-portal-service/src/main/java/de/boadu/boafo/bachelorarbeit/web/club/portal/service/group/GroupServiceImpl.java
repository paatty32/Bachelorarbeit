package de.boadu.boafo.bachelorarbeit.web.club.portal.service.group;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.*;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.repository.GroupRequestRepository;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.repository.GroupRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class GroupServiceImpl implements GroupService {

    private final GroupRepository traininGroupRepository;

    private final GroupRequestRepository groupRequestRepository;

    @Override
    public Group createTraininGroup(MutableGroup newGroupToCreate) {

        GroupDTO savedGroupDTO = this.getTraininGroupRepository().save((GroupDTO) newGroupToCreate);

        return savedGroupDTO;

    }

    @Override
    public List<Group> getAllTrainingGroups() {

        List<GroupDTO> trainingGroup = this.getTraininGroupRepository().findAll();

        List<Group> groups = new ArrayList<>();
        groups.addAll(trainingGroup);

        return groups;


    }

    @Override
    public void addGroupRequest(Long groupId, MutableGroupRequest request) {

        GroupDTO trainingGroupById = this.getTraininGroupRepository().getTrainingGroupById(groupId);
        Set<GroupRequestsDTO> groupRequests = trainingGroupById.getRequests();
        groupRequests.add((GroupRequestsDTO) request);

        this.getTraininGroupRepository().save(trainingGroupById);

    }

    @Override
    public List<GroupRequest> getGroupRequestByAdmin(Long adminId) {

        List<GroupRequestsDTO> groupRequestsByAdminId = this.getGroupRequestRepository().getGroupRequestsByAdminId(adminId);

        List<GroupRequest> groupRequests = new ArrayList<>();
        groupRequests.addAll(groupRequestsByAdminId);

        return groupRequests;

    }


    @Override
    public Group getTrainingGroupById(Long groupId) {

        GroupDTO trainingGroupById = this.getTraininGroupRepository().getTrainingGroupById(groupId);

        return trainingGroupById;

    }

    @Override
    public void deleteGroupequestById(Long requesterId, Long groupId) {

        GroupDTO trainingGroupById = this.getTraininGroupRepository().getTrainingGroupById(groupId);

        GroupRequestsDTO groupRequestsById = this.getGroupRequestRepository().getGroupRequestByRequesterIdAndGroupId(requesterId, groupId);
        trainingGroupById.getRequests().remove(groupRequestsById);

        this.getTraininGroupRepository().save(trainingGroupById);

    }

    @Override
    public List<Group> getTrainingGroupsByAdmin(Long userId) {

        List<GroupDTO> trainingGroupByAdminIdBuffer = this.getTraininGroupRepository().getTrainingGroupByAdminId(userId);

        List<Group> groupByAdminId = new ArrayList<>(trainingGroupByAdminIdBuffer);

        return groupByAdminId;

    }

}
