package com.tajprod.regicide.controllers;

import com.tajprod.regicide.board.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping("/play")
  public String play(Model model) {
    int[] files = {1, 2, 3, 4, 5, 6, 7, 8};
    String[] colTags = {"a", "b", "c", "d", "e", "f", "g", "h"};

    Board board = new Board();

    model.addAttribute("cols", files);
    model.addAttribute("rows", files);
    model.addAttribute("colTags", colTags);

    model.addAttribute("whitePieces", board.getWhitePieces());
    model.addAttribute("blackPieces", board.getBlackPieces());

    return "game.jsp";
  }
}