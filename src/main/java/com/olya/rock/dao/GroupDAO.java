package com.olya.rock.dao;

import com.olya.rock.model.Group;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDAO {
  private List<Group> groupList;

  @PostConstruct
  public void init() {
    groupList = new ArrayList<>();
    groupList.add(new Group("Slayer", "Thrash metal", 972614));
    groupList.add(new Group("AC/DC", "Music", 42000000));
    groupList.add(new Group("Scorpions", "Hard rock", 100000000));
    groupList.add(new Group("Metallica", "Thrash metal", 25540));
    groupList.add(new Group("Linkin Park", "Nu metal", 47085648));
    groupList.add(new Group("Queen", "Hard rock", 15912000));
    groupList.add(new Group("System of a Down", "Progressive metal", 62126));
  }

  public List<Group> getAllGroups() {
    return groupList;
  }

  public Group getGroupById(int id) {
    if (id >= 0 && id < groupList.size()) {
      return groupList.get(id);
    }
    throw new IndexOutOfBoundsException("Group with ID " + id + " not found");
  }
}