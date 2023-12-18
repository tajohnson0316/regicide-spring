package com.tajprod.regicide.board.cell;

import java.util.HashMap;
import java.util.Map;

/*
 * Use the Cell Engine to handle all Cell utility operations
 */

public class CellEngine {
  public static final String[][] cellMatrix = new String[8][8];
  private static final Map<String, Cell> cellMap = new HashMap<>();

  static {
    // Fill the matrix with tags (a1, a2, a3, ...etc.)
    String[] columns = {"a", "b", "c", "d", "e", "f", "g", "h"};
    for (int col = 0; col < cellMatrix.length; col++) {
      for (int row = 0; row < cellMatrix[col].length; row++) {
        String cellTag = columns[col] + (row + 1);

        cellMatrix[col][row] = cellTag;

        // fill the cellMap with all of its corresponding cells
        cellMap.put(cellTag, new Cell(col + 1, row + 1, cellTag));
      }
    }
  }

  public static Cell parseCellTag(String cellTag) {
    return cellMap.get(cellTag);
  }

  public static String convertToTag(int x, int y) {
    int colIdx = x - 1;
    int rowIdx = y - 1;

    return cellMatrix[colIdx][rowIdx];
  }
}