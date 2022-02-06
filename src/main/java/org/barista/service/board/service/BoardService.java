package org.barista.service.board.service;

import org.barista.service.board.dto.BoardDto;
import org.barista.service.board.dto.BoardSearchDto;

import java.util.List;

public interface BoardService {
    List <BoardDto> getList(BoardSearchDto searchDto);
}
