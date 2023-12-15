package com.tajprod.regicide.board.cell;

import com.tajprod.regicide.board.piece.Piece;

public class Cell {
  private final int row;
  private final int col;
  private final String name;
  private Piece piece;

  public Cell(int col, int row) {
    String[] colTags = {"a", "b", "c", "d", "e", "f", "g", "h"};
    this.col = col;
    this.row = row;
    this.name = String.format("%s%d", colTags[col - 1], row);
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public String getName() {
    return name;
  }

  public Piece getPiece() {
    return piece;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }
}