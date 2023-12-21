package com.tajprod.regicide.board.piece.lospiece.rook;

import com.tajprod.regicide.board.piece.lospiece.LoSPiece;

import java.util.ArrayList;
import java.util.List;

public class Rook extends LoSPiece {
  public Rook(String color, String location) {
    super(color, "_rook", location);
    this.flag = "R";
    this.value = 5;
  }

  @Override
  public List<String> getLegalMoves() {
    this.legalMoves = new ArrayList<>();

    // forward direction
    validateForwardFile();
    // reverse direction
    validateReverseFile();
    // left direction
    validateLeftFile();
    // right direction
    validateRightFile();

    return legalMoves;
  }
}