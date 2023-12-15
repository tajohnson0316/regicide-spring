package com.tajprod.regicide.board;

import com.tajprod.regicide.board.piece.Piece;
import com.tajprod.regicide.board.piece.bishop.BishopFactory;
import com.tajprod.regicide.board.piece.king.KingFactory;
import com.tajprod.regicide.board.piece.knight.KnightFactory;
import com.tajprod.regicide.board.piece.pawn.PawnFactory;
import com.tajprod.regicide.board.piece.queen.QueenFactory;
import com.tajprod.regicide.board.piece.rook.RookFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
  public static final String[] columns = {"a", "b", "c", "d", "e", "f", "g", "h"};
  public static final String[] rows = {"1", "2", "3", "4", "5", "6", "7", "8"};

  private List<Piece> whitePieces = new ArrayList<>();
  private List<Piece> blackPieces = new ArrayList<>();

  private Map<String, Piece> cellPieceMap = new HashMap<>();

  public Board() {
    initializePieces();
    List<Piece> allPieces = new ArrayList<>(whitePieces);
    allPieces.addAll(blackPieces);
    for (Piece piece : allPieces) {
      cellPieceMap.put(piece.getLocation(), piece);
    }
  }

  private void initializePieces() {
    // pawns
    PawnFactory pawnFactory = new PawnFactory();
    whitePieces.addAll(pawnFactory.initialize("white"));
    blackPieces.addAll(pawnFactory.initialize("black"));

    // knights
    KnightFactory knightFactory = new KnightFactory();
    whitePieces.addAll(knightFactory.initialize("white"));
    blackPieces.addAll(knightFactory.initialize("black"));

    // bishops
    BishopFactory bishopFactory = new BishopFactory();
    whitePieces.addAll(bishopFactory.initialize("white"));
    blackPieces.addAll(bishopFactory.initialize("black"));

    // rooks
    RookFactory rookFactory = new RookFactory();
    whitePieces.addAll(rookFactory.initialize("white"));
    blackPieces.addAll(rookFactory.initialize("black"));

    // queen
    QueenFactory queenFactory = new QueenFactory();
    whitePieces.addAll(queenFactory.initialize("white"));
    blackPieces.addAll(queenFactory.initialize("black"));

    // king
    KingFactory kingFactory = new KingFactory();
    whitePieces.addAll(kingFactory.initialize("white"));
    blackPieces.addAll(kingFactory.initialize("black"));
  }

  public List<Piece> getWhitePieces() {
    return whitePieces;
  }

  public List<Piece> getBlackPieces() {
    return blackPieces;
  }
}