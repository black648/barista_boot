package org.barista.service.attach.dto;

import lombok.Data;
import org.barista.framework.base.BaseDto;
import org.barista.service.attach.entity.AttachEntity;

@Data
public class AttachDto extends BaseDto {
    private String id;
    private String savedFileName;
    private String orgFileName;
    private String fileExt;
    private String fileSize;
    private String dirPath;
    private String realDirPath;
//    private String modifierNo;
    private String division;
    private String divisionId;
    private Long sortOrder;


    public AttachEntity toAttachEntity() {
        return AttachEntity.builder()
                .id(id)
                .savedFileName(savedFileName)
                .fileExt(fileExt)
                .dirPath(dirPath)
                .division(division)
                .divisionId(divisionId)
                .sortOrder(sortOrder)
                .build();
    }

}
