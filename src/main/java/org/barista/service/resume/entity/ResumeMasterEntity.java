package org.barista.service.resume.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="resumemaster")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeMasterEntity  implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(100)")
    private String RESUMESN;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RNO;

    @Column(columnDefinition = "varchar(400)")
    private String TITLE;

    @Column(columnDefinition = "int")
    private Long REGISTERNO;

    @Column(columnDefinition = "varchar(100)")
    private String REGISTERNAME;

    @Column(columnDefinition = "varchar(100)")
    private String REGISTERENGNAME;

    @Column(columnDefinition = "varchar(50)")
    private String REGISTERPHONE;

    @Column(columnDefinition = "varchar(1)")
    private String SEX;

    @Column(columnDefinition = "varchar(8)")
    private String BIRTH;

    @Column(columnDefinition = "varchar(300)")
    private String EMAIL;

    @Column(columnDefinition = "varchar(1)")
    private String STATUS;

    @Column
    @Lob
    private String RESUMEAPPLY;

    @Column
    @Lob
    private String RESUMENATURE;

    @Column
    @Lob
    private String RESUMEAMBITION;

}
