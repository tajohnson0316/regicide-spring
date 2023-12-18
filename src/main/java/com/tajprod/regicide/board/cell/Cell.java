package com.tajprod.regicide.board.cell;

public record Cell(int col, int row, String tag) {
  public Cell {
    if (col > 8 || col < 1 || row > 8 || row < 1) {
      throw new IllegalArgumentException(
        String.format("Out of bounds - column %d, row %d", col, row)
      );
    }
  }
}