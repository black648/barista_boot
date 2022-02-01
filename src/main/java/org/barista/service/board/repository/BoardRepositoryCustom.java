package org.barista.service.board.repository;

import org.barista.service.board.entity.BoardEntity;
import org.barista.service.common.dto.SearchCommonDto;

import java.util.List;

public interface BoardRepositoryCustom {
    List<BoardEntity> getList(SearchCommonDto searchCommonDto);
}
