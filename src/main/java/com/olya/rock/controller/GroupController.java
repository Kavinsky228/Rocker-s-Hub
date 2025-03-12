package com.olya.rock.controller;

import com.olya.rock.exceptions.GroupNotFoundException;
import com.olya.rock.model.Group;
import com.olya.rock.service.GroupService;
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
public class GroupController {
  private final GroupService groupService;

  public GroupController(GroupService groupsService) {
    this.groupService = groupsService;
  }

  @GetMapping
  public List<Group> getAllGroups() {
    return groupService.getAllGroups();
  }

  @GetMapping("/filter")
  public List<Group> getGroupsByGenre(@RequestParam String genre) {
    return groupService.getGroupsByGenre(genre);
  }

  @GetMapping("/{id}")
  public Group getGroupById(@PathVariable int id) {
    return groupService.getGroupById(id);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(GroupNotFoundException.class)
  public ResponseEntity<String> handleGroupNotFoundException(GroupNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
}