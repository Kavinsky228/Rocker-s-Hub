package com.olya.rock.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Group {
  private String name;
  private String genre;
  private int listeners;

  public Group(String name, String genre, int listeners) {
    this.name = name;
    this.genre = genre;
    this.listeners = listeners;
  }

}
