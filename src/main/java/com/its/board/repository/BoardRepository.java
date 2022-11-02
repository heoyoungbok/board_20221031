package com.its.board.repository;

import com.its.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int boardSave(BoardDTO boardDTO) {
        return sql.insert("Board.boardSave",boardDTO);
    }

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }

    public BoardDTO findById(Long id) {
        return sql.selectOne("Board.findById",id);
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits",id);  // 조회수 쿼리 별개로 처리 파인드 바이 아디랑 별개
    }

    public void update(BoardDTO boardDTO) {
         sql.update("Board.update",boardDTO);
    }

    public void delete(Long id) {
        sql.delete("Board.delete",id);
    }

//    public void updateHit(int num) {
//        sql.update("Board.updateHit",num);
//    }
}
