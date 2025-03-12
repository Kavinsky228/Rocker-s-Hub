package com.olya.rock.service;

import com.olya.rock.dao.GroupDAO;
import com.olya.rock.exceptions.GroupNotFoundException;
import com.olya.rock.model.Group;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
  private final GroupDAO groupsDAO;

  public GroupService(GroupDAO groupsDAO) {
    this.groupsDAO = groupsDAO;
  }

  public List<Group> getAllGroups() {
    return groupsDAO.getAllGroups();
  }

  public List<Group> getGroupsByGenre(String genre) {
    List<Group> allGroups = groupsDAO.getAllGroups();
    List<Group> filteredGroups = new ArrayList<>();
    for (Group group : allGroups) {
      if (group.getGenre().equalsIgnoreCase(genre)) {
        filteredGroups.add(group);
      }
    }
    if (filteredGroups.isEmpty()) {
      throw new GroupNotFoundException("Groups not found for genre: " + genre);
    }
    return filteredGroups;
  }

  public Group getGroupById(int id) {
    try {
      return groupsDAO.getGroupById(id);
    } catch (IndexOutOfBoundsException e) {
      throw new GroupNotFoundException("Group with ID " + id + " not found");
    }
  }
}