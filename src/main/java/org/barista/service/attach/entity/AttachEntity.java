package org.barista.service.attach.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="attach")
@ToString
@Getter
@NoArgsConstructor
public class AttachEntity extends BaseEntity {

    @Id
    @Column(columnDefinition = "varchar(20)")
    private String id;

    //저장된 파일명
    @Column(columnDefinition = "varchar(100)")
    private String savedFileName;

    //원본파일명
    @Column(columnDefinition = "varchar(100)")
    private String orgFileName;

    //파일확장자
    @Column(columnDefinition = "varchar(20)")
    private String fileExt;

    @Column(columnDefinition = "varchar(200)")
    private String fileSize;

    //파일저장소
    @Column(columnDefinition = "varchar(100)")
    private String dirPath;

    //상태여부
    @Column(columnDefinition = "varchar(100)")
    private String state;

    //파일 저장된 모듈
    @Column(columnDefinition = "varchar(100)")
    private String division;

    //모듈 그룹핑 UUID
    @Column(columnDefinition = "varchar(50)")
    private String divisionId;

    //첨부파일 순서
    @Column(columnDefinition = "int")
    private Long sortOrder;

    @Builder
    public AttachEntity(String id, String savedFileName, String orgFileName, String fileExt, String fileSize, String dirPath, String state, String division, String divisionId, Long sortOrder) {
        super();
        this.id = id;
        this.savedFileName = savedFileName;
        this.orgFileName = orgFileName;
        this.fileExt = fileExt;
        this.fileSize = fileSize;
        this.dirPath = dirPath;
        this.state = state;
        this.division = division;
        this.divisionId = divisionId;
        this.sortOrder = sortOrder;
    }
}