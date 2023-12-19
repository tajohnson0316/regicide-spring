package com.tajprod.regicide.board.piece.king;

import com.tajprod.regicide.board.piece.Piece;

import java.util.List;
import java.util.Map;

public class King extends Piece {
  public King(String color, String location) {
    super(color, "_king", location);
    this.flag = "K";
    this.value = 99;
  }

  @Override
  public List<String> getLegalMoves(Map<String, Piece> pieceMap) {
    return null;
  }
}