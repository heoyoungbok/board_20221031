package com.its.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class BoardDTO {
   private Long id;
   private String boardWriter;
   private String boardPass;
   private String boardTitle;
   private String boardContents;
   private LocalDateTime boardCreatedDate;
   private int boardHits ;



}
