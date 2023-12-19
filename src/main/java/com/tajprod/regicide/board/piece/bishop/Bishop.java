package com.tajprod.regicide.board.piece.bishop;

import com.tajprod.regicide.board.piece.Piece;

import java.util.List;
import java.util.Map;

public class Bishop extends Piece {
  public Bishop(String color, String location) {
    super(color, "_bishop", location);
    this.flag = "B";
    this.value = 3;
  }

  @Override
  public List<String> getLegalMoves(Map<String, Piece> pieceMap) {
    return null;
  }
}