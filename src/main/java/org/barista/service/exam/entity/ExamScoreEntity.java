package org.barista.service.exam.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="examscore")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamScoreEntity {


    @Column(columnDefinition = "varchar(100)")
    private String examSn;

    @Id
    @Column(columnDefinition = "varchar(100)")
    private String apcSn;

    @Column(columnDefinition = "smallint")
    private int section1;

    @Column(columnDefinition = "smallint")
    private int section2;

    @Column(columnDefinition = "smallint")
    private int section3;

    @Column(columnDefinition = "smallint")
    private int section4;

    @Column(columnDefinition = "smallint")
    private int section5;

    @Column(columnDefinition = "smallint")
    private int total;

    @Column(columnDefinition = "smallint")
    private int score;

    @Column(columnDefinition = "varchar(2)")
    private String failYn;

    @Column(columnDefinition = "varchar(2)")
    private String passYn;

    @Column(columnDefinition = "varchar(12)")
    private String calculationDe;

}
