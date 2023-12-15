package com.tajprod.regicide.board.piece.rook;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.piece.Piece;

public class Rook extends Piece {
  public Rook(String color, String location) {
    super(color, "_rook", location);
    this.flag = "R";
    this.value = 5;
  }

  @Override
  public Cell move() {
    return null;
  }
}