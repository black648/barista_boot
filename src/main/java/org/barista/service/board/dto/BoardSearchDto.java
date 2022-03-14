package org.barista.service.board.dto;

import lombok.Data;
import org.barista.framework.base.BaseSearchDto;

@Data
public class BoardSearchDto extends BaseSearchDto {
    private String id;
    private String instanceId;
    private String content;
    private String title;
    private String isPublic;
    private String isNotice;
    private String delYn;
}
