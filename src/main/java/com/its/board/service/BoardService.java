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
        return boardRepository.findAll();
    }

    public BoardDTO findById(Long id) {


//        int hits = boardHit +1;

        return boardRepository.findById(id);
    }
}

//    public void updateHit(int num) {
//        boardRepository.updateHit(num);
//    }
//}
