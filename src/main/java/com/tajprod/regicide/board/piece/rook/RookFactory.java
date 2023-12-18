package com.tajprod.regicide.board.piece.rook;

import com.tajprod.regicide.board.piece.Piece;
import com.tajprod.regicide.board.piece.PieceFactory;

import java.util.ArrayList;
import java.util.List;

public class RookFactory implements PieceFactory {
  @Override
  public List<Piece> initialize(String color) {
    String row = "1";
    if (color.equalsIgnoreCase("black")) {
      row = "8";
    }
    List<Piece> newRooks = new ArrayList<>();
    newRooks.add(new Rook(color, "a" + row));
    newRooks.add(new Rook(color, "h" + row));

    return newRooks;
  }
}