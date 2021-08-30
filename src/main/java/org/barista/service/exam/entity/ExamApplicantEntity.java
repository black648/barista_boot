package org.barista.service.exam.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="examapplicant")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamApplicantEntity extends BaseEntity {


    @Column(columnDefinition = "varchar(100)")
    private String examSn;

    @Id
    @Column(columnDefinition = "varchar(100)")
    private String apcSn;

    @Column(columnDefinition = "varchar(20)")
    private String registerNo;

    @Column(columnDefinition = "varchar(100)")
    private String registerName;

    @Column(columnDefinition = "varchar(2)")
    private String grade;

    @Column(columnDefinition = "varchar(400)")
    private String registerEngName;

    @Column(columnDefinition = "varchar(10)")
    private String birth;

    @Column(columnDefinition = "varchar(20)")
    private String examPlaceCode;

}
