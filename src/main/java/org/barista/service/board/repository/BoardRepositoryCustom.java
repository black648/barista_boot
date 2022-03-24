package org.barista.service.board.repository;

import com.querydsl.core.types.Expression;
import org.barista.service.board.dto.BoardDto;
import org.barista.service.board.dto.BoardSearchDto;

import java.util.List;

public interface BoardRepositoryCustom {
    List<BoardDto> getList(BoardSearchDto searchDto);
    List<BoardDto> getList(BoardSearchDto searchDto, Expression<?>... expressions);
}
