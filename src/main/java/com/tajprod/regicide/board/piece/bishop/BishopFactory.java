package com.tajprod.regicide.board.piece.bishop;

import com.tajprod.regicide.board.piece.Piece;
import com.tajprod.regicide.board.piece.PieceFactory;

import java.util.ArrayList;
import java.util.List;

public class BishopFactory implements PieceFactory {
  @Override
  public List<Piece> initialize(String color) {
    String row = "1";
    if (color.equalsIgnoreCase("black")) {
      row = "8";
    }
    List<Piece> newBishops = new ArrayList<>();
    newBishops.add(new Bishop(color, "c" + row));
    newBishops.add(new Bishop(color, "f" + row));

    return newBishops;
  }
}