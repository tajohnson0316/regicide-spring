package com.tajprod.regicide.board.piece.lospiece.bishop;

import com.tajprod.regicide.board.piece.lospiece.LoSPiece;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends LoSPiece {
  public Bishop(String color, String location) {
    super(color, "_bishop", location);
    this.flag = "B";
    this.value = 3;
  }

  @Override
  public List<String> getLegalMoves() {
    this.legalMoves = new ArrayList<>();
    // forward-right direction
    validateForwardRightDiagonals();
    // reverse-right direction
    validateReverseRightDiagonals();
    // forward-left direction
    validateForwardLeftDiagonals();
    // reverse-left direction
    validateReverseLeftDiagonals();

    return this.legalMoves;
  }
}