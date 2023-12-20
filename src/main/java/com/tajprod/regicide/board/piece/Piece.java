package com.tajprod.regicide.board.piece;

import com.tajprod.regicide.board.Board;
import com.tajprod.regicide.board.cell.CellEngine;

import java.util.List;

public abstract class Piece {
  protected String flag;
  protected int value;
  protected String name;
  protected String imageURL;
  protected String color;
  protected String cellTag;
  protected List<String> legalMoves;

  public Piece(String color, String name, String cellTag) {
    this.color = color;
    this.cellTag = cellTag;
    this.name = color + name;
    this.imageURL = String.format("images/%s/%s.png", this.color, this.name);
  }

  // ========== ABSTRACT METHODS ==========

  /*
   * HOW TO DETERMINE MOVES
   * 1.) Loop through all corresponding in-bound cells
   * 2.) Collect valid, legal moves
   */
  public abstract List<String> getLegalMoves();

  // ========== UTILITY METHODS ==========

  protected boolean foundBlockedCell(int x, int y) {
    String cell = CellEngine.convertToTag(x, y);

    if (cell == null) {
      return true;
    } else if (Board.pieceMap.containsKey(cell)) { // if the cell is occupied...
      Piece piece = Board.pieceMap.get(cell);
      if (!piece.getColor().equals(this.color)) { // if the occupying piece is the opposing color...
        // this piece can take the piece and occupy this cell
        legalMoves.add(cell);
      }
      // the lane is blocked, exit the loop
      return true;
    } else legalMoves.add(cell);

    return false;
  }

  protected void forwardLeftDiagonal(int startingX, int startingY) {
    int cellX = startingX;
    int cellY = startingY;

    while (!foundBlockedCell(cellX, cellY)) {
      cellX--;
      cellY++;
    }
  }

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