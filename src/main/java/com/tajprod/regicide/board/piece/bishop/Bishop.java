package com.tajprod.regicide.board.piece.bishop;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.piece.Piece;

import java.util.List;

public class Bishop extends Piece {
  public Bishop(String color, String location) {
    super(color, "_bishop", location);
    this.flag = "B";
    this.value = 3;
  }

  @Override
  public List<Cell> getLegalMoves() {
    return null;
  }
}