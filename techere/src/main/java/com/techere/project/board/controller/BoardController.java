package com.techere.project.board.controller;

import com.techere.project.board.dto.BoardDto;
import com.techere.project.board.entity.Board;
import com.techere.project.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : 박수현
 * @version : 1.0.0
 * @package : com.techere.board.controller
 * @name : BoardController
 * @create-date: 2022.11.23
 * @update-date :
 * @update-author : 000
 * @update-description :
 */

@Slf4j
@RestController
@RequestMapping(value = "api/v1/boards")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public List<Board> retrieveTransportation() {
        return boardService.retrieveBoardList();
    }

    @PostMapping
    public Board createTransportation(BoardDto boarddto) {
        return boardService.createBoard(boarddto);
    }
}
