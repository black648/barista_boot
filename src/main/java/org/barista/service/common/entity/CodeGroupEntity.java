package org.barista.service.common.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="codegroup")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CodeGroupEntity extends BaseEntity {

    @Id
    @Column(columnDefinition = "varchar(5)")
    private String grpCd;

    //그룹코드명
    @Column(columnDefinition = "varchar(100) not null")
    private String name;

    //그룹코드설명
    @Column(columnDefinition = "varchar(500)")
    private String dscr;

    //코드맥스레벨
    @Column(columnDefinition = "smallint not null")
    private String maxLevel;

    //사용여부
    @Column(columnDefinition = "varchar(1) default 'T' not null")
    private String useAble;

    //정렬순서
    @Column(columnDefinition = "smallint")
    private int orderNo;

    //사용자정의1
    @Column(columnDefinition = "varchar(500)")
    private String userDscr1;

    //사용자정의2
    @Column(columnDefinition = "varchar(500)")
    private String userDscr2;

    //생성자
    @Column(columnDefinition = "varchar(20)")
    private String registerNo;

    //수정자
    @Column(columnDefinition = "varchar(20)")
    private String modifierNo;


}
