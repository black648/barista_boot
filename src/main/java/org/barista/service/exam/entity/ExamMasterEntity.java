package org.barista.service.exam.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="exammaster")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamMasterEntity extends BaseEntity {

    @Id
    @Column(columnDefinition = "varchar(100)")
    private String examSn;

    @Column(columnDefinition = "varchar(50)")
    private String division;

    @Column(columnDefinition = "varchar(200)")
    private String title;

    //내용
    @Column
    @Lob
    private String content;

    @Column
    @Lob
    private String note;

    @Column(columnDefinition = "varchar(12)")
    private String strDe;

    @Column(columnDefinition = "varchar(12)")
    private String endDe;

    @Column(columnDefinition = "varchar(20)")
    private String registerNo;

    @Column(columnDefinition = "varchar(100)")
    private String chargeName;

    @Column(columnDefinition = "varchar(100)")
    private String chargeDept;

    @Column(columnDefinition = "varchar(20)")
    private String modifierNo;

    @Column(columnDefinition = "varchar(8)")
    private String examDe;

    @Column(columnDefinition = "varchar(12)")
    private String publicationDe;


}
