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
  public static final String[][] boardMatrix = new String[8][8];

  private List<Piece> whitePieces = new ArrayList<>();
  private List<Piece> blackPieces = new ArrayList<>();

  private Map<String, Piece> cellPieceMap = new HashMap<>();

  public Board() {
    String[] columns = {"a", "b", "c", "d", "e", "f", "g", "h"};
    String[] rows = {"1", "2", "3", "4", "5", "6", "7", "8"};
    for (int col = 0; col < boardMatrix.length; col++) {
      for (int row = 0; row < boardMatrix[col].length; row++) {
        boardMatrix[col][row] = columns[col] + rows[row];
      }
    }

    initializePieces();

    List<Piece> allPieces = new ArrayList<>(whitePieces);
    allPieces.addAll(blackPieces);
    for (Piece piece : allPieces) {
      cellPieceMap.put(piece.getLocation(), piece);
    }
  }

  public static int[] locationParser(String location) {
    if (location.length() != 2) {
      return null;
    }

    Map<String, Integer> colTagsMap = new HashMap<>();
    colTagsMap.put("a", 0);
    colTagsMap.put("b", 1);
    colTagsMap.put("c", 2);
    colTagsMap.put("d", 3);
    colTagsMap.put("e", 4);
    colTagsMap.put("f", 5);
    colTagsMap.put("g", 6);
    colTagsMap.put("h", 7);

    Map<String, Integer> rowTagsMap = new HashMap<>();
    rowTagsMap.put("1", 0);
    rowTagsMap.put("2", 1);
    rowTagsMap.put("3", 2);
    rowTagsMap.put("4", 3);
    rowTagsMap.put("5", 4);
    rowTagsMap.put("6", 5);
    rowTagsMap.put("7", 6);
    rowTagsMap.put("8", 7);

    int[] result = new int[2];
    result[0] = colTagsMap.get(location.substring(0, 1));
    result[1] = rowTagsMap.get(location.substring(1));


    return result;
  }

  private void initializePieces() {
    // pawns
    PawnFactory pawnFactory = new PawnFactory();
    whitePieces.addAll(pawnFactory.initialize("images/white"));
    blackPieces.addAll(pawnFactory.initialize("images/black"));

    // knights
    KnightFactory knightFactory = new KnightFactory();
    whitePieces.addAll(knightFactory.initialize("images/white"));
    blackPieces.addAll(knightFactory.initialize("images/black"));

    // bishops
    BishopFactory bishopFactory = new BishopFactory();
    whitePieces.addAll(bishopFactory.initialize("images/white"));
    blackPieces.addAll(bishopFactory.initialize("images/black"));

    // rooks
    RookFactory rookFactory = new RookFactory();
    whitePieces.addAll(rookFactory.initialize("images/white"));
    blackPieces.addAll(rookFactory.initialize("images/black"));

    // queen
    QueenFactory queenFactory = new QueenFactory();
    whitePieces.addAll(queenFactory.initialize("images/white"));
    blackPieces.addAll(queenFactory.initialize("images/black"));

    // king
    KingFactory kingFactory = new KingFactory();
    whitePieces.addAll(kingFactory.initialize("images/white"));
    blackPieces.addAll(kingFactory.initialize("images/black"));
  }

  public List<Piece> getWhitePieces() {
    return whitePieces;
  }

  public List<Piece> getBlackPieces() {
    return blackPieces;
  }

  public Map<String, Piece> getCellPieceMap() {
    return cellPieceMap;
  }
}