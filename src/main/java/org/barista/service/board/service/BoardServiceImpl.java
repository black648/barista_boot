package org.barista.service.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.barista.service.board.entity.BoardEntity;
import org.barista.service.board.repository.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {


    private final BoardRepository boardRepository;

    @Override
    public List<BoardEntity> getList(Map<String, Object> paramMap) {
        Sort sort = Sort.by(Sort.Order.asc("registde"));
        List<BoardEntity> list = boardRepository.getList(paramMap, sort);

        return list;
    }
}
