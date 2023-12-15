package com.tajprod.regicide.board.piece.queen;

import com.tajprod.regicide.board.piece.Piece;
import com.tajprod.regicide.board.piece.PieceFactory;

import java.util.ArrayList;
import java.util.List;

public class QueenFactory implements PieceFactory {
  @Override
  public List<Piece> initialize(String color) {
    String row = "1";
    if (color.equalsIgnoreCase("black")) {
      row = "8";
    }
    List<Piece> newQueen = new ArrayList<>();
    newQueen.add(new Queen(color, "d" + row));

    return newQueen;
  }
}