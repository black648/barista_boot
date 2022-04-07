package org.barista.service.board.service;

import com.querydsl.core.types.dsl.StringPath;
import lombok.RequiredArgsConstructor;
import org.barista.framework.base.BaseRepository;
import org.barista.framework.base.BaseServiceImpl;
import org.barista.service.board.dto.BoardDto;
import org.barista.service.board.entity.QBoardEntity;
import org.barista.service.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl extends BaseServiceImpl<BoardDto> implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public BaseRepository getRepository() {
        return boardRepository;
    }

    public void update() {
        Map<String, StringPath> map = new HashMap<>();
        map.put("내용122", QBoardEntity.boardEntity.content);
        map.put("제목12222222", QBoardEntity.boardEntity.title);

        boardRepository.update(map);
    }

    public void saveD() {
        boardRepository.saveD();
    }


}
