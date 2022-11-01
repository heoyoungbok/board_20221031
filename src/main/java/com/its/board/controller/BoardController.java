package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board/save")
    public String boardSaveForm() {
        return "boardSave";
    }

    // 리턴타입 boardList
    // 매개변수 DTO타입
    //


    @PostMapping("/board/save")
    public String boardSave(@ModelAttribute BoardDTO boardDTO, Model model) {
        boolean saveResult = boardService.boardSave(boardDTO);
        model.addAttribute("saveResult", saveResult);
        return "boardList";
    }

    @GetMapping("/board/")
    public String findAll(Model model) {
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "boardList";

    }






       @GetMapping("/board")
       public String findById(@RequestParam("id")  Long id,
                               @RequestParam("hits") int hits,
                               Model model){
//        boardService.updateHit(num);
           int  hits = hits +1;
        BoardDTO boardDTO = boardService.findById(id,hits);
        model.addAttribute("board",boardDTO);




//       = boardService.findById(id);

        return "boardDetail";
       }



}
//   @GetMapping("/board")
//
//    }

