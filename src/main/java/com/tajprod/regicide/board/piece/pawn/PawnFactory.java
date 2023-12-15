package com.tajprod.regicide.board.piece.pawn;

import com.tajprod.regicide.board.piece.Piece;
import com.tajprod.regicide.board.piece.PieceFactory;

import java.util.ArrayList;
import java.util.List;

public class PawnFactory implements PieceFactory {
  @Override
  public List<Piece> initialize(String color) {
    String[] columns = {"a", "b", "c", "d", "e", "f", "g", "h"};

    String row = "2";
    if (color.equalsIgnoreCase("images/black")) {
      row = "7";
    }
    List<Piece> newPawns = new ArrayList<>();

    for (int p = 0; p < 8; p++) {
      newPawns.add(
        new Pawn(color, columns[p] + row)
      );
    }
    return newPawns;
  }
}