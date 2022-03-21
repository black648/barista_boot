package org.barista.service.board.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.barista.framework.base.BaseSearchDto;

import java.util.List;

@Data
public class BoardSearchDto extends BaseSearchDto {
    private String id;
    private String instanceId;
    private String content;
    private String title;
    private String isPublic;
    private String isNotice;
    private String delYn;

    @JsonIgnore
    private List<String> columnList;
}
