package org.barista.service.attach.dto;

import lombok.Data;
import org.barista.framework.base.BaseSearchDto;

@Data
public class AttachSearchDto extends BaseSearchDto {
    private String id;
    private String savedFileName;
    private String orgFileName;
    private String dirPath;
//    private String modifierNo;
    private String division;
    private String divisionId;
    private Long sortOrder;

    private String[] ids;
}
