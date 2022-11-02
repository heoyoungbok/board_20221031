package com.its.board.service;

import com.its.board.dto.BoardDTO;
import com.its.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public boolean boardSave(BoardDTO boardDTO) {
        int result = boardRepository.boardSave(boardDTO);
        if (result > 0) {
            return true;
        } else {
            return false;
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
}

//    public void updateHit(int num) {
//        boardRepository.updateHit(num);
//    }
//}
