package com.techere.project.board.service;

import com.techere.project.board.dto.BoardDto;
import com.techere.project.board.entity.Board;

import java.util.List;

/**
 * @author : 박수현
 * @version : 1.0.0
 * @package : com.techere.board.service
 * @name : BoardService
 * @create-date: 2022.11.23
 * @update-date :
 * @update-author : 000
 * @update-description :
 */
public interface BoardService {

    public Board createBoard(BoardDto boarddto);

    public List<Board> retrieveBoardList();

}
