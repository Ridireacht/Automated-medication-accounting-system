package com.vasiliy.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequest {

  private String type;
  private String value;


  public boolean typeMatchesAny(String[] strings) {
    if (type == null || strings == null) {
      return false;
    }
    for (String str : strings) {
      if (type.equals(str)) {
        return true;
      }
    }
    return false;
  }
}
