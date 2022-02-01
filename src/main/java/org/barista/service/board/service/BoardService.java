package org.barista.service.board.service;

import org.barista.service.board.entity.BoardEntity;
import org.barista.service.common.dto.SearchCommonDto;

import java.util.List;

public interface BoardService {
    List <BoardEntity> getList(SearchCommonDto searchCommonDto);
}
