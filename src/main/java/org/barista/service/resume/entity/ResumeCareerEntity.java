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
    @Column(columnDefinition = "varchar(100)")
    private String resumesn;

    @Column(columnDefinition = "varchar(8)")
    private String beginde;

    @Column(columnDefinition = "varchar(8)")
    private String endde;

    @Column(columnDefinition = "varchar(400)")
    private String companyname;

    @Column(columnDefinition = "varchar(100)")
    private String position;

    @Column(columnDefinition = "varchar(400)")
    private String assigntask;

    @Column(columnDefinition = "varchar(100)")
    private String devision;

}
