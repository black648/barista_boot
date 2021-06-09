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
    private String EXAMSN;

    @Id
    @Column(columnDefinition = "varchar(100)")
    private String APCSN;

    @Column(columnDefinition = "int")
    private Long REGISTERNO;

    @Column(columnDefinition = "varchar(100)")
    private String REGISTERNAME;

    @Column(columnDefinition = "varchar(2)")
    private String GRADE;

    @Column(columnDefinition = "varchar(400)")
    private String REGISTERENGNAME;

    @Column(columnDefinition = "varchar(10)")
    private String BIRTH;

    @Column(columnDefinition = "varchar(20)")
    private String EXAMPLACECODE;

}
