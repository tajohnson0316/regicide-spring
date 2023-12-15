package com.tajprod.regicide.board.piece.knight;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.piece.Piece;

public class Knight extends Piece {
  public Knight(String color, String location) {
    super(color, location);
    this.flag = "N";
    this.value = 3;
    this.name = color + "_knight";
  }

  @Override
  public Cell move() {
    return null;
  }
}