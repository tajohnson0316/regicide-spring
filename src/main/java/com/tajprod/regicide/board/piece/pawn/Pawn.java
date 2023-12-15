package com.tajprod.regicide.board.piece.pawn;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.piece.Piece;

public class Pawn extends Piece {
  public Pawn(String color, String location) {
    super(color, location);
    this.flag = "";
    this.value = 1;
    this.name = color + "_pawn";
  }

  @Override
  public Cell move() {
    return null;
  }
}