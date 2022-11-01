package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/save")  // @GetMapping("/board/save")  @RequestMapping x 겟이든 포스트든 다 받고 /board 라는걸 반응 /board/board/save 라고 반응
    public String saveForm() {
        return "boardPages/boardSave"; // 뷰즈 보드페이지 / 보드세이브
    }

    // 리턴타입 boardList
    // 매개변수 DTO타입
    //
//    @RequestMapping(value = "/save",method =  RequestMethod.POST)
//    public String save(){
//        return null;
//    }
//



    @PostMapping("/save")
    public String boardSave(@ModelAttribute BoardDTO boardDTO) {
        boolean saveResult = boardService.boardSave(boardDTO);

        if (saveResult){
            return "redirect:/board/";
        }else{

        }
        return "saveFail";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "boardPages/boardList";

    }






       @GetMapping("/board")
       public String findById(@RequestParam("id")  Long id,
//                               @RequestParam("hits") int hits,
                               Model model){
//        boardService.updateHit(num);
//           int  hits = hits +1;
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board",boardDTO);




//       = boardService.findById(id);

        return "boardDetail";
       }



}
//   @GetMapping("/board")
//
//    }

