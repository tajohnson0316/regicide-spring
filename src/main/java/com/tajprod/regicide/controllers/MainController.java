package com.tajprod.regicide.controllers;

import com.tajprod.regicide.board.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping("/play")
  public String play(Model model) {
    int[] colIndices = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] rowIndices = {8, 7, 6, 5, 4, 3, 2, 1};

    model.addAttribute("cols", colIndices);
    model.addAttribute("rows", rowIndices);
    model.addAttribute("boardMatrix", Board.boardMatrix);

    Board board = new Board();

    model.addAttribute("whitePieces", board.getWhitePieces());
    model.addAttribute("blackPieces", board.getBlackPieces());
    model.addAttribute("cellPieceMap", board.getCellPieceMap());

    return "game.jsp";
  }
}