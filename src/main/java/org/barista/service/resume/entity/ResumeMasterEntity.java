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
    @Column(columnDefinition = "varchar(20)")
    private String resumeSn;

    @Column(columnDefinition = "varchar(400)")
    private String title;

    @Column(columnDefinition = "varchar(20)")
    private String registerNo;

    @Column(columnDefinition = "varchar(1)")
    private String status;

    @Column
    @Lob
    private String resumeApply;

    @Column
    @Lob
    private String resumeNature;

    @Column
    @Lob
    private String resumeAmbition;

}
