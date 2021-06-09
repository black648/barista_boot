package org.barista.service.edu.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="eduemaster")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EduMasterEntity extends BaseEntity {

    @Id
    @Column(columnDefinition = "varchar(100)")
    private String EDUSN;

    @Column(columnDefinition = "varchar(50)")
    private String DIVISION;

    @Column(columnDefinition = "varchar(200)")
    private String TITLE;

    //내용
    @Column
    @Lob
    private String CONTENT;

    //내용
    @Column
    @Lob
    private String CONTENT1;

    //내용
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
    private String EDUBEGINDE;

    @Column(columnDefinition = "varchar(8)")
    private String EDUENDDE;

    //접수
    @Column(columnDefinition = "int")
    private Long PEOPLECNT;

}
