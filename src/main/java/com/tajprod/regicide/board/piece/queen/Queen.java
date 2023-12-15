package com.tajprod.regicide.board.piece.queen;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.piece.Piece;

public class Queen extends Piece {
  public Queen(String color, String location) {
    super(color, "_queen", location);
    this.flag = "Q";
    this.value = 9;
  }

  @Override
  public Cell move() {
    return null;
  }
}