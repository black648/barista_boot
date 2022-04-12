package org.barista.service.board.repository;

import com.querydsl.core.types.dsl.StringPath;
import org.barista.framework.base.BaseRepository;
import org.barista.service.board.dto.BoardDto;

import java.util.Map;

public interface BoardRepositoryCustom extends BaseRepository<BoardDto> {
//    List<BoardDto> getList(BoardSearchDto searchDto);
//    List<BoardDto> getList(BoardSearchDto searchDto, Expression<?>... expressions);
    void update(String UID, Map<String, Object> paramMap);
    void saveD();
}
