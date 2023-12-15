package com.tajprod.regicide.board.piece.pawn;

import com.tajprod.regicide.board.Board;
import com.tajprod.regicide.board.piece.Piece;
import com.tajprod.regicide.board.piece.PieceFactory;

import java.util.ArrayList;
import java.util.List;

public class PawnFactory implements PieceFactory {
  @Override
  public List<Piece> initialize(String color) {
    String row = "2";
    if (color.equalsIgnoreCase("black")) {
      row = "7";
    }
    List<Piece> newPawns = new ArrayList<>();

    for (int p = 0; p < 8; p++) {
      newPawns.add(
        new Pawn(color, Board.columns[p] + row)
      );
    }
    return newPawns;
  }
}