package com.tajprod.regicide.board.piece;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.cell.CellEngine;

import java.util.List;

public abstract class Piece {
  protected String flag;
  protected int value;
  protected String name;
  protected String imageURL;
  protected String color;
  protected Cell currentCell;
  protected String cellTag;
  protected List<String> legalMoves;

  public Piece(String color, String name, String cellTag) {
    this.color = color;
    this.name = color + name;
    this.currentCell = CellEngine.parseCellTag(cellTag);
    this.cellTag = cellTag;
    this.imageURL = String.format("images/%s/%s.png", this.color, this.name);
  }

  // ========== ABSTRACT METHODS ==========

  /*
   * HOW TO DETERMINE MOVES
   * 1.) Loop through all corresponding in-bound cells
   * 2.) Collect valid, legal moves
   * 3.) TODO: Logic for ensuring move does not put King in check
   */
  public abstract List<String> getLegalMoves();

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

  public String getCellTag() {
    return cellTag;
  }

  public void setCellTag(String cellTag) {
    this.cellTag = cellTag;
  }

  public List<String> getValidMoves() {
    return legalMoves;
  }

  public String getImageURL() {
    return imageURL;
  }

  @Override
  public String toString() {
    return String.format("%s located at %s [%s%s], valued at %d point(s) with an image URL: %s",
      this.name, this.cellTag, this.flag, this.cellTag, this.value, this.imageURL);
  }
}