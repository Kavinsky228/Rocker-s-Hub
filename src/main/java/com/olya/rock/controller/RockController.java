package com.olya.rock.controller;

import com.olya.rock.model.Groups;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/groups")
public class RockController {

  private static final String HARD_ROCK = "Hard rock";
  private static final String THRASH_METAL = "Thrash metal";

  private final List<Groups> groups = Arrays.asList(
      new Groups("Slayer", THRASH_METAL, 972614),
      new Groups("AC/DC", HARD_ROCK, 42000000),
      new Groups("Scorpions", HARD_ROCK, 100000000),
      new Groups("Metallica", THRASH_METAL, 25540),
      new Groups("Lnkin Park", "Nu metal", 47085648),
      new Groups("Queen", HARD_ROCK, 15912000),
      new Groups("System of a down", "Progressive metal", 62126));

  // GET-запрос для получения всех групп
  @GetMapping
  public List<Groups> findAllGroups() {
    return groups;
  }

  // GET-запрос с Query Parameters (например, /api/v1/groups/filter?genre=Rock)
  @GetMapping("/filter")
  public List<Groups> findGroupsByGenre(@RequestParam String genre) {
    return groups.stream()
        .filter(group -> group.getGenre().equalsIgnoreCase(genre))
        .toList();
  }

  // GET-запрос с Path Parameters (например, /api/v1/groups/AC:DC)
  @GetMapping("/{name}")
  public Groups findGroupByName(@PathVariable String name) {
    return groups.stream()
        .filter(group -> group.getName().equalsIgnoreCase(name))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Группа не найдена"));
  }
}
