package com.techere.project.board.repository;

import com.techere.project.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : 박수현
 * @version : 1.0.0
 * @package : com.techere.board.repository
 * @name : BoardRepository
 * @create-date: 2022.11.23
 * @update-date :
 * @update-author : 000
 * @update-description :
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query(value = "select * from board where is_deleted =false", nativeQuery = true)
    public List<Board> findAllByOrderByBoardIdDesc();

}
