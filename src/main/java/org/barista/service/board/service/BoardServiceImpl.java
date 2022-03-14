package org.barista.service.board.service;

import lombok.RequiredArgsConstructor;
import org.barista.framework.constants.ColumnConstants;
import org.barista.service.board.dto.BoardDto;
import org.barista.service.board.dto.BoardSearchDto;
import org.barista.service.board.entity.BoardEntity;
import org.barista.service.board.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {


    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BoardDto> getList(BoardSearchDto searchDto) {
        searchDto.setSort(Sort.by(Sort.Order.desc(ColumnConstants.REGIST_DE)));
        List<BoardEntity> list = boardRepository.getList(searchDto);
//        List<SiteInfoDTO> siteList  = dataList.stream().map(SiteInfo::entityToDTO).collect(Collectors.toList());

//        return BoardDto.getBoardDtoList(list);
//        List<TeamDto> teamDtoList = teamList.stream().map(team -> modelMapper.map(team, TeamDto.class)).collect(Collectors.toList());
//        log.info(teamDtoList.toString());
        return list.stream().map(board -> modelMapper.map(board, BoardDto.class)).collect(Collectors.toList());
    }
}
