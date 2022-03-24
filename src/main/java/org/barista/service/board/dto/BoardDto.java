package org.barista.service.board.dto;

import lombok.Data;
import org.barista.framework.base.BaseDto;

@Data
public class BoardDto extends BaseDto {

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
