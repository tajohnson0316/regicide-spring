package com.tajprod.regicide.board.piece;

import com.tajprod.regicide.board.cell.Cell;

public abstract class Piece {
  protected String flag;
  protected int value;
  protected String name;
  protected String imageURL;
  protected String color;
  protected String location;

  public Piece(String color, String name, String location) {
    this.color = color;
    this.location = location;
    this.name = color + name;
    this.imageURL = String.format("%s.png", this.name);
  }

  // ========== ABSTRACT METHODS ==========

  public abstract Cell move();

  // ========== GETTERS & SETTERS ==========

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getImageURL() {
    return imageURL;
  }

  @Override
  public String toString() {
    return String.format("%s located at %s [%s%s], valued at %d point(s) with an image URL: %s",
      this.name, this.location, this.flag, this.location, this.value, this.imageURL);
  }
}