package com.tajprod.regicide.board.piece.knight;

import com.tajprod.regicide.board.piece.Piece;
import com.tajprod.regicide.board.piece.PieceFactory;

import java.util.ArrayList;
import java.util.List;

public class KnightFactory implements PieceFactory {
  @Override
  public List<Piece> initialize(String color) {
    String row = "1";
    if (color.equalsIgnoreCase("black")) {
      row = "8";
    }
    List<Piece> newKnights = new ArrayList<>();
    newKnights.add(new Knight(color, "b" + row));
    newKnights.add(new Knight(color, "g" + row));

    return newKnights;
  }
}