package com.olya.rock.controller;

import com.olya.rock.exceptions.GroupNotFoundException;
import com.olya.rock.model.Group;
import com.olya.rock.service.GroupsService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/groups")
public class GroupsController {
  private final GroupsService groupsService;

  public GroupsController(GroupsService groupsService) {
    this.groupsService = groupsService;
  }

  @GetMapping
  public List<Group> getAllGroups() {
    return groupsService.getAllGroups();
  }

  @GetMapping("/filter")
  public List<Group> getGroupsByGenre(@RequestParam String genre) {
    return groupsService.getGroupsByGenre(genre);
  }

  @GetMapping("/{name}")
  public Group getGroupByName(@PathVariable String name) {
    return groupsService.getGroupByName(name);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleGroupNotFound(RuntimeException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(GroupNotFoundException.class)
  public ResponseEntity<String> handleGroupNotFound(GroupNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
}
