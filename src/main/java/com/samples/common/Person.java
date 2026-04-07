package com.samples.common;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {

  @Serial
  private static final long serialVersionUID = 7149029222001461931L;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
