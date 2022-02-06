package org.barista.service.board.repository;

import org.barista.service.board.dto.BoardSearchDto;
import org.barista.service.board.entity.BoardEntity;

import java.util.List;

public interface BoardRepositoryCustom {
    List<BoardEntity> getList(BoardSearchDto searchDto);
}
