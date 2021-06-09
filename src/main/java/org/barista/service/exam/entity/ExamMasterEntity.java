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
    private String EXAMSN;

    @Column(columnDefinition = "varchar(50)")
    private String DIVISION;

    @Column(columnDefinition = "varchar(200)")
    private String TITLE;

    //내용
    @Column
    @Lob
    private String CONTENT;

    @Column
    @Lob
    private String NOTE;

    @Column(columnDefinition = "varchar(12)")
    private String BEGINDE;

    @Column(columnDefinition = "varchar(12)")
    private String ENDDE;

    @Column(columnDefinition = "int")
    private Long REGISTERNO;

    @Column(columnDefinition = "varchar(100)")
    private String CHARGENAME;

    @Column(columnDefinition = "varchar(100)")
    private String CHARGEDEPT;

    @Column(columnDefinition = "int")
    private Long MODYFIERNO;

    @Column(columnDefinition = "varchar(8)")
    private String EXAMDE;

    @Column(columnDefinition = "varchar(12)")
    private String PUBLICATIONDE;


}
