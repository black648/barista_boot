package org.barista.service.board.service;

import org.barista.framework.base.BaseService;
import org.barista.service.board.dto.BoardDto;

public interface BoardService extends BaseService<BoardDto> {

    void update();

}
