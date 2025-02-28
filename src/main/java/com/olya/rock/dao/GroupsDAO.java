package com.olya.rock.dao;

import com.olya.rock.model.Group;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class GroupsDAO {
  private List<Group> groups;

  @PostConstruct
  public void init() {
    groups = new ArrayList<>();
    groups.add(new Group("Slayer", "Thrash metal", 972614));
    groups.add(new Group("AC/DC", "Music", 42000000));
    groups.add(new Group("Scorpions", "Hard rock", 100000000));
    groups.add(new Group("Metallica", "Thrash metal", 25540));
    groups.add(new Group("Linkin Park", "Nu metal", 47085648));
    groups.add(new Group("Queen", "Hard rock", 15912000));
    groups.add(new Group("System of a Down", "Progressive metal", 62126));
  }

  public List<Group> getAllGroups() {
    return groups;
  }
}
