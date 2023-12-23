package com.tajprod.regicide.board.piece.knight;

import com.tajprod.regicide.board.piece.Piece;

import java.util.List;

public class Knight extends Piece {
  public Knight(String color, String location) {
    super(color, "_knight", location);
    this.flag = "N";
    this.value = 3;
  }

  /*
   * KNIGHT CONDITIONS
   * can move +/-2 rows and -/+1 column
   * can move +/-1 row and -/+2 columns
   * can "jump over" pieces
   * > All conditions assume the cell is either empty or holding an opposing piece
   */
  @Override
  public List<String> getLegalMoves() {
    return null;
  }
}