package com.tajprod.regicide.board.piece.queen;

import com.tajprod.regicide.board.piece.Piece;

import java.util.List;
import java.util.Map;

public class Queen extends Piece {
  public Queen(String color, String location) {
    super(color, "_queen", location);
    this.flag = "Q";
    this.value = 9;
  }

  @Override
  public List<String> getLegalMoves(Map<String, Piece> pieceMap) {
    return null;
  }
}