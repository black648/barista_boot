package org.barista.service.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.barista.framework.base.BaseSearchDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BoardSearchDto extends BaseSearchDto {

    private String id;
    private String instanceId;
    private String content;
    private String title;
    private String isPublic;
    private String isNotice;
    private String delYn;
}
