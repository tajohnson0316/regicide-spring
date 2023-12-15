package com.tajprod.regicide.board.piece.bishop;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.piece.Piece;

public class Bishop extends Piece {
  public Bishop(String color, String location) {
    super(color, location);
    this.flag = "B";
    this.value = 3;
    this.name = "bishop";
  }

  @Override
  public Cell move() {
    return null;
  }
}