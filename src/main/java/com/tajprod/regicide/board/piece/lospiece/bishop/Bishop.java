package com.tajprod.regicide.board.piece.lospiece.bishop;

import com.tajprod.regicide.board.piece.lospiece.LoSPiece;

import java.util.List;

public class Bishop extends LoSPiece {
  public Bishop(String color, String location) {
    super(color, "_bishop", location);
    this.flag = "B";
    this.value = 3;
  }

  @Override
  public List<String> getLegalMoves() {
    return null;
  }
}