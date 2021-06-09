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
    private String GRPCD;

    //그룹코드명
    @Column(columnDefinition = "varchar(100) not null")
    private String GRPCDNAME;

    //그룹코드설명
    @Column(columnDefinition = "varchar(500)")
    private String GRPCDDSCR;

    //코드맥스레벨
    @Column(columnDefinition = "smallint not null")
    private String CDMAXLVL;

    //사용여부
    @Column(columnDefinition = "varchar(1) default 'T' not null")
    private String USABLE;

    //정렬순서
    @Column(columnDefinition = "smallint")
    private int ORDERNO;

    //사용자정의1
    @Column(columnDefinition = "varchar(500)")
    private String USERDEF1DSCR;

    //사용자정의2
    @Column(columnDefinition = "varchar(500)")
    private String USERDEF2DSCR;

    //생성자
    @Column(columnDefinition = "int")
    private Long REGISTERNO;

    //수정자
    @Column(columnDefinition = "int")
    private Long MODIFIERNO;


}
