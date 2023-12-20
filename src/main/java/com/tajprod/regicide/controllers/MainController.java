package com.tajprod.regicide.controllers;

import com.tajprod.regicide.board.Board;
import com.tajprod.regicide.board.cell.CellEngine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
  @GetMapping("/play")
  public String play(Model model) {
    int[] colIndices = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] rowIndices = {8, 7, 6, 5, 4, 3, 2, 1};

    model.addAttribute("cols", colIndices);
    model.addAttribute("rows", rowIndices);
    model.addAttribute("cellMatrix", CellEngine.cellMatrix);

    Board board = new Board();
    List<String> selectMoves = board.getPieceMap().get("d7").getLegalMoves();

    model.addAttribute("whitePieces", board.getWhitePieces());
    model.addAttribute("blackPieces", board.getBlackPieces());
    model.addAttribute("pieceMap", board.getPieceMap());
    model.addAttribute("selectMoves", selectMoves);

    return "game.jsp";
  }
}