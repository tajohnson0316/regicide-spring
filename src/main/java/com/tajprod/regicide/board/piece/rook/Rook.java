package com.tajprod.regicide.board.piece.rook;

import com.tajprod.regicide.board.piece.Piece;

import java.util.List;
import java.util.Map;

public class Rook extends Piece {
  public Rook(String color, String location) {
    super(color, "_rook", location);
    this.flag = "R";
    this.value = 5;
  }

  @Override
  public List<String> getLegalMoves(Map<String, Piece> pieceMap) {
    return null;
  }
}