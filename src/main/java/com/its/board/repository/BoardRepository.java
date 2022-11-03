package com.its.board.repository;

import com.its.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public BoardDTO boardSave(BoardDTO boardDTO) {
        System.out.println("insert 전 boardDTO = " + boardDTO);
        sql.insert("Board.boardSave",boardDTO);
        System.out.println("insert 후 boardDTO = " + boardDTO); // db에서 외래키로 참조해서 id가 한번더 필요함
        return boardDTO;
    }

    public void saveFileName(BoardDTO boardDTO){
        sql.insert("Board.saveFile",boardDTO);
    }
    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }

    public BoardDTO findById(Long id) {
        BoardDTO boardDTO = sql.selectOne("Board.findById",id);
        if (boardDTO.getFileAttached() == 1) {
            return sql.selectOne("Board.findByIdFile", id);

        }else {
            return boardDTO;
        }
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

    public List<BoardDTO> pagingList(Map<String, Integer> pagingParams) {
        return sql.selectList("Board.pagingList",pagingParams);
    }

    public int boardCount() {
        return sql.selectOne("Board.boardCount");
    }

//    public void updateHit(int num) {
//        sql.update("Board.updateHit",num);
//    }
}
