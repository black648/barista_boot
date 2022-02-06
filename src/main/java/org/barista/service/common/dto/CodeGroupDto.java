package org.barista.service.common.dto;

import lombok.Data;

@Data
public class CodeGroupDto {
    private String grpCd;
    private String name;
    private String dscr;
    private String maxLevel;
    private String useAble;
    private int orderNo;
    private String userDscr1;
    private String userDscr2;
    private String registerNo;
    private String modifierNo;

//    public static CodeGroupDto getCodeGroupDto(CodeGroupEntity entity) {
//        return CodeGroupDto.builder()
//                .grpCd(entity.getGrpCd())
//                .name(entity.getName())
//                .dscr(entity.getDscr())
//                .maxLevel(entity.getMaxLevel())
//                .useAble(entity.getUseAble())
//                .orderNo(entity.getOrderNo())
//                .userDscr1(entity.getUserDscr1())
//                .userDscr2(entity.getUserDscr2())
//                .registerNo(entity.getRegisterNo())
//                .modifierNo(entity.getModifierNo())
//                .build();
//    }
}
