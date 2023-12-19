package com.tajprod.regicide.board.piece.knight;

import com.tajprod.regicide.board.piece.Piece;

import java.util.List;
import java.util.Map;

public class Knight extends Piece {
  public Knight(String color, String location) {
    super(color, "_knight", location);
    this.flag = "N";
    this.value = 3;
  }

  @Override
  public List<String> getLegalMoves(Map<String, Piece> pieceMap) {
    return null;
  }
}