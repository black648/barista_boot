package org.barista.service.attach.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="attach")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttachEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seqno;

    //저장된 파일명
    @Column(columnDefinition = "varchar(100)")
    private String SAVEDFILENAME;

    //원본파일명
    @Column(columnDefinition = "varchar(100)")
    private String ORGFILENAME;

    //파일저장소
    @Column(columnDefinition = "varchar(100)")
    private String DIRPATH;

    //상태여부
    @Column(columnDefinition = "varchar(100)")
    private String STATE;

    //수정자
    @Column(columnDefinition = "int")
    private Long MODIFIERNO;

    //파일 저장된 모듈
    @Column(columnDefinition = "varchar(100)")
    private String DIVISION;

    //모듈 그룹핑 넘버
    @Column(columnDefinition = "int")
    private Long GRPNO;

}