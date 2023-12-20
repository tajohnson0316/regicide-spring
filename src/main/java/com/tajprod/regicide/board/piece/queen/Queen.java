package com.tajprod.regicide.board.piece.queen;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.cell.CellEngine;
import com.tajprod.regicide.board.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
  public Queen(String color, String location) {
    super(color, "_queen", location);
    this.flag = "Q";
    this.value = 9;
  }

  /*
   * QUEEN CONDITIONS (FROM WHITE PERSPECTIVE)
   * can move up to +/-7 rows up and down
   * can move up to +/-7 columns left and right
   * can move up to +/-7 rows and columns diagonally
   * > All conditions assume the cell is either empty or holding an opposing piece
   */
  @Override
  public List<String> getLegalMoves() {
    this.legalMoves = new ArrayList<>();

    // Get the queen's current Cell properties
    Cell currentCell = CellEngine.parseCellTag(cellTag);
    int currentX = currentCell.col();
    int currentY = currentCell.row();

    // forward direction
    for (int y = currentY; y < 8; y++) {
      if (foundBlockedCell(currentX, y)) break;
    }

    // reverse direction
    for (int y = currentY; y > 1; y--) {
      if (foundBlockedCell(currentX, y)) break;
    }

    // left direction
    for (int x = currentX; x > 1; x--) {
      if (foundBlockedCell(x, currentY)) break;
    }

    // right direction
    for (int x = currentX; x < 8; x++) {
      if (foundBlockedCell(x, currentY)) break;
    }

    /*
     * 1.) x and y iterators
     * 2.) while !foundBlockedCell
     * 3.) add to legalMoves
     * 4.) +/-x AND +/- y
     */


    return legalMoves;
  }
}