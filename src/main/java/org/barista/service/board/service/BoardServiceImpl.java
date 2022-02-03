package org.barista.service.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.barista.service.board.dto.BoardSearchDto;
import org.barista.service.board.entity.BoardEntity;
import org.barista.service.board.repository.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {


    private final BoardRepository boardRepository;

    @Override
    public List<BoardEntity> getList(BoardSearchDto searchDto) {
        searchDto.setSort(Sort.by(Sort.Order.desc("registDe")));
        List<BoardEntity> list = boardRepository.getList(searchDto);

        return list;
    }
}
