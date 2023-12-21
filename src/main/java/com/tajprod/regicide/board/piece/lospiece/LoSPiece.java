package com.tajprod.regicide.board.piece.lospiece;

import com.tajprod.regicide.board.Board;
import com.tajprod.regicide.board.cell.CellEngine;
import com.tajprod.regicide.board.piece.Piece;

import java.util.List;

// Line of Sight Pieces have "unlimited" movement along their occupying files
public abstract class LoSPiece extends Piece {

  public LoSPiece(String color, String name, String cellTag) {
    super(color, name, cellTag);
  }

  // ========== ABSTRACT METHODS ==========

  public abstract List<String> getLegalMoves();

  // ========== UTILITY METHODS ==========

  protected void validateForwardFile() {
    for (int y = this.currentCell.row(); y < 8; y++) {
      if (foundBlockedCell(this.currentCell.col(), y)) break;
    }
  }

  protected void validateReverseFile() {
    for (int y = this.currentCell.row(); y > 1; y--) {
      if (foundBlockedCell(this.currentCell.col(), y)) break;
    }
  }

  protected void validateLeftFile() {
    for (int x = this.currentCell.col(); x > 1; x--) {
      if (foundBlockedCell(x, this.currentCell.row())) break;
    }
  }

  protected void validateRightFile() {
    for (int x = this.currentCell.col(); x < 8; x++) {
      if (foundBlockedCell(x, this.currentCell.row())) break;
    }
  }

  protected void validateForwardLeftDiagonals() {
    int cellX = this.currentCell.col();
    int cellY = this.currentCell.row();

    while (!foundBlockedCell(cellX, cellY)) {
      cellX--;
      cellY++;
    }
  }

  protected void validateForwardRightDiagonals() {
    int cellX = this.currentCell.col();
    int cellY = this.currentCell.row();

    while (!foundBlockedCell(cellX, cellY)) {
      cellX++;
      cellY++;
    }
  }

  protected void validateReverseLeftDiagonals() {
    int cellX = this.currentCell.col();
    int cellY = this.currentCell.row();

    while (!foundBlockedCell(cellX, cellY)) {
      cellX--;
      cellY--;
    }
  }

  protected void validateReverseRightDiagonals() {
    int cellX = this.currentCell.col();
    int cellY = this.currentCell.row();

    while (!foundBlockedCell(cellX, cellY)) {
      cellX++;
      cellY--;
    }
  }

  private boolean foundBlockedCell(int x, int y) {
    String cellTag = CellEngine.convertToTag(x, y);

    if (cellTag == null) {
      return true;
    } else if (Board.pieceMap.containsKey(cellTag)) { // if the cell is occupied...
      Piece piece = Board.pieceMap.get(cellTag);
      if (!piece.getColor().equals(this.color)) { // if the occupying piece is the opposing color...
        // this piece can take the piece and occupy this cell
        legalMoves.add(cellTag);
      }
      // the lane is blocked, exit the loop
      return true;
    } else legalMoves.add(cellTag);

    return false;
  }
}