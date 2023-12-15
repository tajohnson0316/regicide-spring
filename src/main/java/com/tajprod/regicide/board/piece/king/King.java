package com.tajprod.regicide.board.piece.king;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.piece.Piece;

public class King extends Piece {
  public King(String color, String location) {
    super(color, location);
    this.flag = "K";
    this.value = 99;
    this.name = color + "_king";
  }

  @Override
  public Cell move() {
    return null;
  }
}