package com.tajprod.regicide.board.piece.lospiece.queen;

import com.tajprod.regicide.board.piece.lospiece.LoSPiece;

import java.util.ArrayList;
import java.util.List;

public class Queen extends LoSPiece {
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

    // forward direction
    validateForwardFile();
    // reverse direction
    validateReverseFile();
    // left direction
    validateLeftFile();
    // right direction
    validateRightFile();
    // forward-right direction
    validateForwardRightDiagonals();
    // reverse-right direction
    validateReverseRightDiagonals();
    // forward-left direction
    validateForwardLeftDiagonals();
    // reverse-left direction
    validateReverseLeftDiagonals();

    /*
     * 1.) x and y iterators
     * 2.) while !foundBlockedCell
     * 3.) add to legalMoves
     * 4.) +/-x AND +/- y
     */


    return legalMoves;
  }
}