package org.barista.service.edu.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="eduapplicant")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EduApplicantEntity extends BaseEntity {


    @Id
    @Column(columnDefinition = "varchar(100)")
    private String apcSn;

    @Column(columnDefinition = "varchar(100)")
    private String eduSn;

    @Column(columnDefinition = "varchar(20)")
    private String registerNo;

    //등록자명
    @Column(columnDefinition = "varchar(100)")
    private String registerName;

    @Column(columnDefinition = "smallint")
    private int zipCode;

    @Column(columnDefinition = "varchar(2000)")
    private String adress1;

    @Column(columnDefinition = "varchar(2000)")
    private String adress2;

    @Column(columnDefinition = "varchar(50)")
    private String phone;

    @Column(columnDefinition = "varchar(50)")
    private String email;

    @LastModifiedDate
    @Column(columnDefinition = "varchar(2)")
    private LocalDateTime finalDe;

    @Column(columnDefinition = "varchar(2)")
    private String finalYn;

    @Column(columnDefinition = "varchar(2)")
    private String eduYn;

    @Column(columnDefinition = "varchar(100)")
    private String registerEngName;

    @Column(columnDefinition = "varchar(50)")
    private String registerPhone;

    @Column(columnDefinition = "varchar(1)")
    private String agree1;

    @Column(columnDefinition = "varchar(1)")
    private String agree2;


/*
EDU_SN       varchar(100) not null,
    APC_SN       varchar(100) not null
        constraint EDU_APPLICANT_PK
            primary key,
    MBER_ID      varchar(100),
    MBER_NAME    varchar(100),
    GUNMUL       varchar(100),
    ADDRESS1     varchar(2000),
    ADDRESS2     varchar(2000),
    MBER_PHONE   varchar(50),
    EMAIL        varchar(50),
    CRE_DE       DATE,
    UPD_DE       DATE,
    FINAL_DE     DATE,
    FINAL_YN     varchar(2),
    EDU_YN       varchar(2),
    MBER_ENGNAME varchar(400),
    AGREE1       varchar(1),
    AGREE2       varchar(1)
 */
}
