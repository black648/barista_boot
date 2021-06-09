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
    private String APCSN;

    @Column(columnDefinition = "varchar(100)")
    private String EDUSN;

    @Column(columnDefinition = "int")
    private Long REGISTERNO;

    //등록자명
    @Column(columnDefinition = "varchar(100)")
    private String REGISTERNAME;

    @Column(columnDefinition = "smallint")
    private int ZIPCODE;

    @Column(columnDefinition = "varchar(2000)")
    private String ADRESS1;

    @Column(columnDefinition = "varchar(2000)")
    private String ADRESS2;

    @Column(columnDefinition = "varchar(50)")
    private String PHONE;

    @Column(columnDefinition = "varchar(50)")
    private String EMAIL;

    @LastModifiedDate
    @Column(columnDefinition = "varchar(2)")
    private LocalDateTime FINALDE;

    @Column(columnDefinition = "varchar(2)")
    private String FINALYN;

    @Column(columnDefinition = "varchar(2)")
    private String EDUYN;

    @Column(columnDefinition = "varchar(100)")
    private String REGISTERENGNAME;

    @Column(columnDefinition = "varchar(50)")
    private String REGISTERPHONE;

    @Column(columnDefinition = "varchar(1)")
    private String AGREE1;

    @Column(columnDefinition = "varchar(1)")
    private String AGREE2;


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
