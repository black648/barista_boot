package org.barista.service.board.dto;

import lombok.Data;

@Data
public class BoardDto {

    private String id;
    private String instanceId;
    private String content;
    private String title;
    private String isPublic;
    private String isNotice;
    private String delYn;


//    public static BoardDto getBoardDto (BoardEntity entity) {
//        return BoardDto.builder()
//                .id(entity.getId())
//                .instanceId(entity.getInstanceId())
//                .content(entity.getContent())
//                .title(entity.getTitle())
//                .isPublic(entity.getIsPublic())
//                .isNotice(entity.getIsNotice())
//                .delYn(entity.getDelYn())
//                .build();
//    }
//
//    public static List<BoardDto> getBoardDtoList (List<BoardEntity> list) {
//        return list.stream().map(BoardDto::getBoardDto).collect(Collectors.toList());
//    }

}
