package com.tajprod.regicide.board.piece.rook;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.piece.Piece;

public class Rook extends Piece {
  public Rook(String color, String location) {
    super(color, location);
    this.flag = "R";
    this.value = 5;
    this.name = color + "_rook";
  }

  @Override
  public Cell move() {
    return null;
  }
}