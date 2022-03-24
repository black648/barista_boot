package org.barista.service.common.dto;

import lombok.Data;
import org.barista.framework.base.BaseDto;

import java.util.Collection;

@Data
public class CodeDto extends BaseDto {
    private String grpCd;
    private String cd;
    private String pcd;
    private int level;
    private String name;
    private String dscr;
    private String useAble;
    private int orderNo;
    private String strDe;
    private String endDe;
    private String registerNo;
    private String modifierNo;
    private String mappingCd;
    private String mappingName;
    private String userDef1;
    private String userDef2;
    private String userDef3;
    private Collection<CodeDto> codeList;

//    public static CodeDto getCodeDto(CodeEntity entity) {
//        return CodeDto.builder()
//                .grpCd(entity.getGrpCd())
//                .cd(entity.getCd())
//                .pcd(entity.getPcd())
//                .level(entity.getLevel())
//                .name(entity.getName())
//                .dscr(entity.getDscr())
//                .useAble(entity.getUseAble())
//                .orderNo(entity.getOrderNo())
//                .strDe(entity.getStrDe())
//                .endDe(entity.getEndDe())
//                .registerNo(entity.getRegisterNo())
//                .modifierNo(entity.getModifierNo())
//                .mappingCd(entity.getMappingCd())
//                .userDef1(entity.getUserDef1())
//                .userDef2(entity.getUserDef2())
//                .userDef3(entity.getUserDef3())
//                .build();
//    }
}
