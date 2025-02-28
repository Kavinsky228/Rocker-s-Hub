package com.olya.rock.service;

import com.olya.rock.dao.GroupsDAO;
import com.olya.rock.exceptions.GroupNotFoundException;
import com.olya.rock.model.Group;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class GroupsService {
  private final GroupsDAO groupsDAO;

  public GroupsService(GroupsDAO groupsDAO) {
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
      throw new GroupNotFoundException("Группы не найдены для жанра: " + genre);
    }
    return filteredGroups;
  }


  public Group getGroupByName(String name) {
    List<Group> allGroups = groupsDAO.getAllGroups();
    for (Group group : allGroups) {
      if (group.getName().equalsIgnoreCase(name)) {
        return group;
      }
    }
    throw new GroupNotFoundException("Группа не найдена: " + name);
  }
}
