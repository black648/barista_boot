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
    private String EXAMSN;

    @Id
    @Column(columnDefinition = "varchar(100)")
    private String APCSN;

    @Column(columnDefinition = "smallint")
    private int SECTION1;

    @Column(columnDefinition = "smallint")
    private int SECTION2;

    @Column(columnDefinition = "smallint")
    private int SECTION3;

    @Column(columnDefinition = "smallint")
    private int SECTION4;

    @Column(columnDefinition = "smallint")
    private int SECTION5;

    @Column(columnDefinition = "smallint")
    private int TOTAL;

    @Column(columnDefinition = "smallint")
    private int SCORE;

    @Column(columnDefinition = "varchar(2)")
    private String FAILYN;

    @Column(columnDefinition = "varchar(2)")
    private String PASSYN;

    @Column(columnDefinition = "varchar(12)")
    private String CALCULATIONDE;

}
