package org.barista.service.board.service;

import lombok.RequiredArgsConstructor;
import org.barista.framework.base.BaseRepository;
import org.barista.framework.base.BaseServiceImpl;
import org.barista.service.board.dto.BoardDto;
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
        Map<String, Object> map = new HashMap<>();
        map.put("content", "내용이에요");
        map.put("title", "제목입니당");

        boardRepository.update("", map);
    }

    public void saveD() {
        boardRepository.saveD();
    }


}
