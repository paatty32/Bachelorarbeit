package de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.repository;

import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.group.GroupDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<GroupDTO, Long> {

    GroupDTO save(GroupDTO trainingGroup);

    List<GroupDTO> findAll();

    GroupDTO getTrainingGroupById(Long id);

    List<GroupDTO> getTrainingGroupByAdminId(Long adminId);
}
