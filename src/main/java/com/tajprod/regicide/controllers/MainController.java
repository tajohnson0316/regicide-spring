package com.tajprod.regicide.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping("/play")
  public String play(Model model) {
    /*
     * 1.) Initialize board
     * 2.) Render a square for each cell in cellPieceMap
     * */


    int[] files = {1, 2, 3, 4, 5, 6, 7, 8};
    String[] colTags = {"a", "b", "c", "d", "e", "f", "g", "h"};

    model.addAttribute("cols", files);
    model.addAttribute("rows", files);
    model.addAttribute("colTags", colTags);

    return "game.jsp";
  }
}