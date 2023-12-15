package com.tajprod.regicide.board.piece.king;

import com.tajprod.regicide.board.piece.Piece;
import com.tajprod.regicide.board.piece.PieceFactory;

import java.util.ArrayList;
import java.util.List;

public class KingFactory implements PieceFactory {
  @Override
  public List<Piece> initialize(String color) {
    String row = "1";
    if (color.equalsIgnoreCase("images/black")) {
      row = "8";
    }
    List<Piece> newKing = new ArrayList<>();
    newKing.add(new King(color, "e" + row));

    return newKing;
  }
}