package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.dto.CommentDTO;
import com.its.board.dto.PageDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/save")
    // @GetMapping("/board/save")  @RequestMapping x 겟이든 포스트든 다 받고 /board 라는걸 반응 /board/board/save 라고 반응
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
    public String boardSave(@ModelAttribute BoardDTO boardDTO) throws IOException {    // 반드시 post 여야 한다
        boardService.boardSave(boardDTO);

        return "redirect:/board/";


    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "boardPages/boardList";

    }

    // 페이징목록
    @GetMapping("/paging")
    public String paging(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        // 해당 페이지에서 보여줄 글 목록
        List<BoardDTO> pagingList = boardService.pagingList(page);
        //하단 페이지 번호 표현을 위한 데이터
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
//        System.out.println("model = " + model + ", page = " + page);
        return "boardPages/boardPaging";
    }


    // 상세조회: /board?id=  겟맵핑만 사용
    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model,
//
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
//        boardService.updateHit(num);
//           int  hits = hits +1;

        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("page", page);


//       = boardService.findById(id);
        System.out.println("조회: boardDTO = " + boardDTO); // 조인 확인 2개 테이블을 동시에 봐야 하기때문에 조인이라는 DB 명령문을 사용  파일 2개이상인 경우는 테이블을 분리
        return "boardPages/boardDetail";
    }


    @GetMapping("/deleteCheck")
    public String deleteCheck(@RequestParam("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/deleteCheck";
    }

    //return "redirect:/board";
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        boardService.delete(id);
        return "redirect:/board/";
    }


    // 수정화면 요청
    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {  //데이터를 주는게 없엇음 (404에러)
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/boardUpdate";
    }


    //수정처리
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "boardPages/boardDetail";
        // 수정이 처리 후 상세페이지 출력
        //redirect  상세페이지 요청
//         if (result){
//             return "redirect:/board?id=" + boardDTO.getId();   // 조회수가 자동적으로 올라감
//             //db에서 가져와서 boardDetail 출력
//         }else {
//             return "index";
//         }
////            return "boardPages/boardDetail";
//           "redirect:/board?id="+boardDTO.getId();
    }

    @GetMapping("/search")
    public String search(@RequestParam("type") String type,
                         @RequestParam("q") String q, Model model) {
        List<BoardDTO> searchList = boardService.search(type, q);
        model.addAttribute("boardList", searchList);
        return "boardPages/boardList";
    }


}

//    @GetMapping("/update")
//    public String updateForm(){
//        return "boardPages/boardList";lve Board.findById-Inline
//### The error occurred while setting parameters
//### SQL: select *from board_table where id=
//### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
//; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
//	org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
//	org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
//	javax.servlet.http.HttpServlet.service(HttpServlet.java:670)
//	org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
//	javax.servlet.http.HttpServlet.service(HttpServlet.java:779)
//	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
//	org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
//	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
//근본 원인 (root cause)
//
//org.springframework.jdbc.BadSqlGrammarException:
//### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
//### The error may exist in file [C:\springframework\board_20221031\target\mvc_test\WEB-INF\classes\mapper\boardMapper.xml]
//### The error may involve Board.findById-Inline
//### The error occurred while setting parameters
//### SQL: select *from board_table where id=
//### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
//; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 1
//	org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator.doTranslate(SQLErrorCodeSQLExceptionTranslator.java:239)
//	org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:72)
//	org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
//	org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
//	com.sun.proxy.$Proxy7.selectOne(Unknown Source)
//	org.mybatis.spring.SqlSessionTemplate.selectOne(SqlSessionTemplate.java:166)
//	com.its.board.repository.BoardRepository.findById(BoardRepository.java:26)
//	com.its.board.service.BoardService.findById(BoardService.java:37)
//    }
//
//    @PostMapping("/update")
//    public  String update(@RequestParam("id") Long id, Model model){
//        int boardDTO = boardService.update(Long id);
//        model.addAttribute("board",boardDTO);
//        return "boardPages/boardDetail";
//    }
//





//   @GetMapping("/board")
//
//    }

