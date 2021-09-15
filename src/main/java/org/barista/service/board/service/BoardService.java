package org.barista.service.board.service;

import org.barista.service.board.entity.BoardEntity;

import java.util.List;
import java.util.Map;

public interface BoardService {
    List <BoardEntity> getList(Map<String, Object> paramMap);
}
