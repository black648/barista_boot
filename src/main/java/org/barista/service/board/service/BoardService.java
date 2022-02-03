package org.barista.service.board.service;

import org.barista.service.board.dto.BoardSearchDto;
import org.barista.service.board.entity.BoardEntity;

import java.util.List;

public interface BoardService {
    List <BoardEntity> getList(BoardSearchDto searchCommonDto);
}
