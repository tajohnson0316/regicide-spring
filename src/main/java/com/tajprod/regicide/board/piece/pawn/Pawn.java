package com.tajprod.regicide.board.piece.pawn;

import com.tajprod.regicide.board.Board;
import com.tajprod.regicide.board.cell.CellEngine;
import com.tajprod.regicide.board.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pawn extends Piece {
  private boolean hasMoved = false;

  public Pawn(String color, String location) {
    super(color, "_pawn", location);
    this.flag = "";
    this.value = 1;
  }

  /*
   * PAWN CONDITIONS (FROM WHITE PERSPECTIVE)
   * can move +1 row if the cell is vacant
   * can move +1 row AND +/-1 column if an opposing piece is in the cell
   * can promote on row 8
   * FIRST MOVE ONLY: can move +2 rows
   * TODO: EN PASSANT
   */
  @Override
  public List<String> getLegalMoves() {
    this.legalMoves = new ArrayList<>();

    // Get the pawn's current Cell properties
    int currentX = currentCell.col();
    int currentY = currentCell.row();

    int newY;
    // because black pawns move DOWN through rows
    if (color.equals("black")) {
      newY = currentY - 1;
    } else {
      newY = currentY + 1;
    }

    // TOP-LEFT CONDITIONS
    String topLeft = CellEngine.convertToTag(currentX - 1, newY);
    if (topLeft != null) { // if top-left cell is in bounds...
      if (!Board.pieceMap.containsKey(topLeft)) { // if the top-left cell is empty...
        // the pawn cannot move diagonally into an empty cell
        topLeft = null;
      } else { // the top-left cell is occupied...
        if (Board.pieceMap.get(topLeft).getColor().equals(this.color)) { // if the occupying piece is friendly...
          // the pawn cannot take its own pieces
          topLeft = null;
        }
      }
    }

    // FORWARD CONDITIONS
    String forward = CellEngine.convertToTag(currentX, newY);
    if (forward != null) { // if forward cell is in bounds...
      if (Board.pieceMap.containsKey(forward)) { // if the forward cell is not empty...
        // the pawn cannot move onto an occupied cell
        forward = null;
      }

      // DOUBLE-FORWARD CONDITIONS
      if (!hasMoved && forward != null) { // if the pawn is has not left home...
        int doubleForwardY;
        if (color.equals("black")) {
          doubleForwardY = newY - 1;
        } else {
          doubleForwardY = newY + 1;
        }
        String doubleForward = CellEngine.convertToTag(currentX, doubleForwardY);
        if (Board.pieceMap.containsKey(doubleForward)) { // if the double-forward cell is not empty...
          // the pawn cannot move onto an occupied cell
          doubleForward = null;
        }

        if (doubleForward != null) {
          legalMoves.add(doubleForward);
        }
      }
    }

    // TOP-RIGHT CONDITIONS
    String topRight = CellEngine.convertToTag(currentX + 1, newY);
    if (topRight != null) { // if top-right cell is in bounds...
      if (!Board.pieceMap.containsKey(topRight)) { // if the top-right cell is empty...
        // the pawn cannot move diagonally into an empty cell
        topRight = null;
      } else { // the top-right cell is occupied...
        if (Board.pieceMap.get(topRight).getColor().equals(this.color)) { // if the occupying piece is friendly...
          // the pawn cannot take its own pieces
          topRight = null;
        }
      }
    }

    // If the pawn has no legal moves, return null
    if (topLeft == null && forward == null && topRight == null) {
      return null;
    }

    legalMoves.add(topLeft);
    legalMoves.add(forward);
    legalMoves.add(topRight);

    legalMoves.removeIf(Objects::isNull);

    return legalMoves;
  }
}