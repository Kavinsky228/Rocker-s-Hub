package com.olya.rock.service;

import com.olya.rock.dta.GroupsDTA;
import com.olya.rock.model.Groups;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GroupsService {

  private static final String HARD_ROCK = "Hard rock";
  private static final String THRASH_METAL = "Thrash metal";

  private final List<Groups> groups = Arrays.asList(
      new Groups("Slayer", THRASH_METAL, 972614),
      new Groups("AC/DC", HARD_ROCK, 42000000),
      new Groups("Scorpions", HARD_ROCK, 100000000),
      new Groups("Metallica", THRASH_METAL, 25540),
      new Groups("Linkin Park", "Nu metal", 47085648),
      new Groups("Queen", HARD_ROCK, 15912000),
      new Groups("System of a down", "Progressive metal", 62126)
  );

  public List<GroupsDTA> findAllGroups() {
    return groups.stream()
        .map(this::convertToDTO)
        .toList(); // Replaced collect(Collectors.toList()) with toList()
  }

  public List<GroupsDTA> findGroupsByGenre(String genre) {
    return groups.stream()
        .filter(group -> group.getGenre().equalsIgnoreCase(genre))
        .map(this::convertToDTO)
        .toList(); // Replaced collect(Collectors.toList()) with toList()
  }

  public GroupsDTA findGroupByName(String name) {
    return groups.stream()
        .filter(group -> group.getName().equalsIgnoreCase(name))
        .findFirst()
        .map(this::convertToDTO)
        .orElseThrow(() -> new RuntimeException("Группа не найдена"));
  }

  private GroupsDTA convertToDTO(Groups group) {
    return new GroupsDTA(group.getName(), group.getGenre(), group.getListeners());
  }
}