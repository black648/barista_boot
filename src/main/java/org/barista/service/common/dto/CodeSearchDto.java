package org.barista.service.common.dto;

import lombok.Data;
import org.barista.framework.base.BaseSearchDto;

@Data
public class CodeSearchDto extends BaseSearchDto {
    private String grpCd;
    private String cd;
    private String pcd;
    private int level;
    private String useAble;
    private String name;
    private String strDe;
    private String endDe;
}
