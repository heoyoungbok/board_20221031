package com.its.board.service;

import com.its.board.commons.PagingConst;
import com.its.board.dto.BoardDTO;
import com.its.board.dto.PageDTO;
import com.its.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void boardSave(BoardDTO boardDTO) throws IOException {   // 인셉션이 발생해서 패스하기 위함
        /*
        1. boardDTO 객체에 담긴 파일을 꺼냄
        2. 파일의 원본 이름을 가져옴(originalFileName)
        3. 서버 관리용 이름으로 만듦(storedFileName)
        4. originalFileName,storedFileName을 dto 객체에 담음
        5. 파일 실제 저장 위치 지정.
        6. 파일 저장 처리
        7. repository로 dto 객체 전달
         */
        if (!boardDTO.getBoardFile().isEmpty()) {     // 파일 없으면 반전 시켜서
//
            System.out.println("파일있음");
            MultipartFile boardFile = boardDTO.getBoardFile();//1
            String originalFilename = boardFile.getOriginalFilename();//2
//        int result = boardRepository.boardSave(boardDTO);
//        if (result > 0) {
//            return true;
//        } else {
//            return false;
//        }
            System.out.println("originalFilename = " + originalFilename);
            System.out.println(System.currentTimeMillis());
            String storedFileName = System.currentTimeMillis() + "-" + originalFilename;//3
            System.out.println("storedFileName = " + storedFileName);
            boardDTO.setOriginalFileName(originalFilename);
            boardDTO.setStoredFileName(storedFileName);//4
            String savePath = "C:\\spring_img\\" + storedFileName;//5  서버 경로
            boardFile.transferTo(new File(savePath)); // 파일이 있으면 저장해라  //6     데이터 베이스는 파일이 아니라 , 파일이름만 저장
            boardDTO.setFileAttached(1);
            BoardDTO savedBoard = boardRepository.boardSave(boardDTO); // 7
            boardRepository.saveFileName(savedBoard);
        }else {
            System.out.println("파일없음");
            boardDTO.setFileAttached(0);
            boardRepository.boardSave(boardDTO);

        }

    }

    public List<BoardDTO> findAll() {

        List<BoardDTO> boardDTOList = boardRepository.findAll();
        return boardDTOList;
    }

    public BoardDTO findById(Long id) {

        // 조회수 증가
            // 조회수 증가 쿼리 먼저 치고
        // 상세 내용 가져오기 리턴
//        int hits = boardHit +1;

        return boardRepository.findById(id);
    }


    public void updateHits(Long id){
        boardRepository.updateHits(id);
    }



    public void update(BoardDTO boardDTO) {
       boardRepository.update(boardDTO);
//        if(result > 0){
//            return  true;
//        }else {
//            return  false;
//        }
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }


    public List<BoardDTO> pagingList(int page) {
    /*
    * page=1 0
    * page=2 3
    * page=3 6  id값이랑 별개*/

        int pagingStart=(page-1) * PagingConst.PAGE_LIMIT; /* 페이지생성 */
        Map<String,Integer> pagingParams = new HashMap<>(); /* 해쉬 맵을 사용시 2개를 넘겨줄 수 있음  */
        pagingParams.put("start",pagingStart);
        pagingParams.put("limit",PagingConst.PAGE_LIMIT);
        List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
        return pagingList;
    }

    public PageDTO pagingParam(int page) {
        // 전체 글 갯수 조회
        int boardCount = boardRepository.boardCount();
        int maxPage = (int) (Math.ceil((double) boardCount / PagingConst.PAGE_LIMIT));  // 전체 개수  한페이지에 얼마나 보여줄건지 5나누기 3을 하면 1로 나옴 자바 계산식 Math.ceil 올림처리 메서드 올림처리를 해서 강제 형변환
        // 시작 페이지 값 계산(1.4.7.10 ~~~~)
        int startPage = (((int)(Math.ceil((double) page / PagingConst.BLOCK_LIMIT))) - 1) * PagingConst.BLOCK_LIMIT + 1;
        // 끝 페이지 값 계산(3.6.9.12 ~~~~)
        int endPage = startPage + PagingConst.BLOCK_LIMIT - 1;
        if (endPage > maxPage){
            endPage = maxPage;            // if문으로 처리 엔드가 글이 5개 페이지가 2개 3을 보일 필요가 없기 때문

        }
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPage(page);
        pageDTO.setMaxPage(maxPage);
        pageDTO.setStartPage(startPage);
        pageDTO.setEndPage(endPage);
        return pageDTO;
    }

    public List<BoardDTO> search(String type, String q) {
        Map<String,String> searchParams = new HashMap<>();
        searchParams.put("type",type);
        searchParams.put("q",q);
        List<BoardDTO> searchList = boardRepository.search(searchParams);
        return searchList;
    }
}

//    public void updateHit(int num) {
//        boardRepository.updateHit(num);
//    }
//}
