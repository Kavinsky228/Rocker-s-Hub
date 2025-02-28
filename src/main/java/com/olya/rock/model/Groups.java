package com.olya.rock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Groups {
  private String groupName;
  private String genreMusic;
  private Integer daysExistence;

  public String getGenre() {
    return genreMusic;
  }

  public String getName() {
    return groupName;
  }
}
