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
    private String resumesn;

    @Column(columnDefinition = "varchar(400)")
    private String title;

    @Column(columnDefinition = "varchar(20)")
    private String registerno;

    @Column(columnDefinition = "varchar(100)")
    private String registername;

    @Column(columnDefinition = "varchar(100)")
    private String registerengname;

    @Column(columnDefinition = "varchar(50)")
    private String registerphone;

    @Column(columnDefinition = "varchar(1)")
    private String sex;

    @Column(columnDefinition = "varchar(8)")
    private String birth;

    @Column(columnDefinition = "varchar(300)")
    private String email;

    @Column(columnDefinition = "varchar(1)")
    private String status;

    @Column
    @Lob
    private String resumeapply;

    @Column
    @Lob
    private String resumenature;

    @Column
    @Lob
    private String resumeambition;

}
