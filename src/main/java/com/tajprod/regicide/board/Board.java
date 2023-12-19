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
  private List<Piece> whitePieces = new ArrayList<>();
  private List<Piece> blackPieces = new ArrayList<>();

  private Map<String, Piece> pieceMap = new HashMap<>();

  public Board() {
    initializePieces();
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

    // Collect all pieces and put them in their appropriate locations on the piece map
    List<Piece> allPieces = new ArrayList<>(whitePieces);
    allPieces.addAll(blackPieces);
    for (Piece piece : allPieces) {
      String cellTag = piece.getCellTag();
      pieceMap.put(cellTag, piece);
    }
  }

  public List<Piece> getWhitePieces() {
    return whitePieces;
  }

  public List<Piece> getBlackPieces() {
    return blackPieces;
  }

  public Map<String, Piece> getPieceMap() {
    return pieceMap;
  }
}