package com.olya.rock.controller;

import com.olya.rock.dta.GroupsDTA;
import com.olya.rock.exceptions.GroupNotFoundException;
import com.olya.rock.service.GroupsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/groups")
public class RockController {

  private final GroupsService groupsService;

  public RockController(GroupsService groupsService) {
    this.groupsService = groupsService;
  }


  @GetMapping
  public List<GroupsDTA> findAllGroups() {
    return groupsService.findAllGroups();
  }


  @GetMapping("/filter")
  public List<GroupsDTA> findGroupsByGenre(@RequestParam String genre) {
    return groupsService.findGroupsByGenre(genre);
  }


  @GetMapping("/{name}")
  public GroupsDTA findGroupByName(@PathVariable String name) {
    return groupsService.findGroupByName(name);
  }

  @ExceptionHandler(GroupNotFoundException.class)
  public ResponseEntity<String> handleGroupNotFoundException(GroupNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

}
