package com.tajprod.regicide.board.piece;

import java.util.List;

public interface PieceFactory {
  List<Piece> initialize(String color);
}