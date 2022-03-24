package org.barista.service.board.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import org.barista.service.board.entity.QBoardEntity;

import java.util.List;

@Data
public class BoardDto {

    private String id;
    private String instanceId;
    private String content;
    private String title;
    private String isPublic;
    private String isNotice;
    private String delYn;

    private String registerName;
    private String modifierName;

}
