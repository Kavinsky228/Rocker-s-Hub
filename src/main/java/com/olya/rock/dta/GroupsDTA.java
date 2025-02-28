package com.olya.rock.dta;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupsDTA {
  private String name;
  private String genre;
  private int listeners;


  public GroupsDTA(String name, String genre, int listeners) {
    this.name = name;
    this.genre = genre;
    this.listeners = listeners;
  }

}