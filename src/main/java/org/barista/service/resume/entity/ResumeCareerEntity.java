package org.barista.service.resume.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="resumecareer")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeCareerEntity extends BaseEntity implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(20)")
    private String resumeSn;

    @Column(columnDefinition = "varchar(8)")
    private String beginDe;

    @Column(columnDefinition = "varchar(8)")
    private String endDe;

    @Column(columnDefinition = "varchar(100)")
    private String companyName;

    @Column(columnDefinition = "varchar(100)")
    private String position;

    @Column(columnDefinition = "varchar(400)")
    private String assignTask;

    @Column(columnDefinition = "varchar(50)")
    private String division;

}
