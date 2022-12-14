package com.its.board.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.sql.Timestamp;
@Getter
@Setter
@ToString
public class PageDTO {
    private int page; // 현재페이지
    private int maxPage; // 필요한페이지개수
    private int startPage; // 시작페이지
    private int endPage;  // 끝 페이지
}
