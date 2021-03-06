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
    @Column(columnDefinition = "varchar(20)")
    private String seqNo;

    //저장된 파일명
    @Column(columnDefinition = "varchar(100)")
    private String savedFileName;

    //원본파일명
    @Column(columnDefinition = "varchar(100)")
    private String orgFileName;

    //파일저장소
    @Column(columnDefinition = "varchar(100)")
    private String dirPath;

    //상태여부
    @Column(columnDefinition = "varchar(100)")
    private String state;

    //수정자
    @Column(columnDefinition = "varchar(20)")
    private String modifierNo;

    //파일 저장된 모듈
    @Column(columnDefinition = "varchar(100)")
    private String division;

    //모듈 그룹핑 넘버
    @Column(columnDefinition = "varchar(50)")
    private String divisionId;

    //첨부파일 순서
    @Column(columnDefinition = "int")
    private Long grpNo;

}