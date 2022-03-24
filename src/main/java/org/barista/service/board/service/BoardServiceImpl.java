package org.barista.service.board.service;

import lombok.RequiredArgsConstructor;
import org.barista.service.board.dto.BoardDto;
import org.barista.service.board.dto.BoardSearchDto;
import org.barista.service.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {


    private final BoardRepository boardRepository;

    @Override
    public List<BoardDto> getList(BoardSearchDto searchDto) {
        searchDto.setSort(searchDto.getOrder(), searchDto.getOrderProperty());
        return boardRepository.getList(searchDto);
    }
}
