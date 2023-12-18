package com.tajprod.regicide.board.piece.pawn;

import com.tajprod.regicide.board.cell.Cell;
import com.tajprod.regicide.board.cell.CellEngine;
import com.tajprod.regicide.board.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
  public Pawn(String color, String location) {
    super(color, "_pawn", location);
    this.flag = "";
    this.value = 1;
  }

  @Override
  public List<Cell> getLegalMoves() {
    this.legalMoves = new ArrayList<>();
    Cell currentCell = CellEngine.parseCellTag(cellTag);

    switch (this.color) {
      case ("white") -> {

      }
      case ("black") -> {

      }
      default -> {
        return null;
      }
    }

    return null;
  }
}