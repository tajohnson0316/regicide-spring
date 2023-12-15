package com.tajprod.regicide.board;

import com.tajprod.regicide.board.piece.Piece;
import com.tajprod.regicide.board.piece.pawn.PawnFactory;

import java.util.ArrayList;
import java.util.List;

public class Board {
  public static final String[] columns = {"a", "b", "c", "d", "e", "f", "g", "h"};
  public static final String[] rows = {"1", "2", "3", "4", "5", "6", "7", "8"};

  private List<Piece> whitePieces = new ArrayList<>();
  private List<Piece> blackPieces = new ArrayList<>();

  public Board() {

  }

  private void initializePieces() {
    PawnFactory pawnFactory = new PawnFactory();
    whitePieces.addAll(pawnFactory.initialize("white"));
    blackPieces.addAll(pawnFactory.initialize("black"));

  }
}