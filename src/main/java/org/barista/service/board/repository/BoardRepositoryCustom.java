package org.barista.service.board.repository;

import org.barista.service.board.entity.BoardEntity;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface BoardRepositoryCustom {
    List<BoardEntity> getList(Map<String, Object> paramMap, Sort sort);
}
