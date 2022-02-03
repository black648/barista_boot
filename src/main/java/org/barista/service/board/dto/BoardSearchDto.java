package org.barista.service.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.barista.service.common.dto.SearchCommonDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BoardSearchDto extends SearchCommonDto {

    private String id;
    private String instanceId;
    private String content;
    private String title;
    private String isPublic;
    private String isNotice;
    private String delYn;
}
