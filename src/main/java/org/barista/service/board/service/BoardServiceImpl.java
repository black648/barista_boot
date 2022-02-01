package org.barista.service.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.barista.service.board.entity.BoardEntity;
import org.barista.service.board.repository.BoardRepository;
import org.barista.service.common.dto.SearchCommonDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {


    private final BoardRepository boardRepository;

    @Override
    public List<BoardEntity> getList(SearchCommonDto searchCommonDto) {
        searchCommonDto.setSort(Sort.by(Sort.Order.asc("registDe")));
        List<BoardEntity> list = boardRepository.getList(searchCommonDto);

        return list;
    }
}
