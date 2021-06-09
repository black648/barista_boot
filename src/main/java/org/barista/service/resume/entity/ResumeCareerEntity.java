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
    private String RESUMESN;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RNO;

    @Column(columnDefinition = "varchar(8)")
    private String BEGINDE;

    @Column(columnDefinition = "varchar(8)")
    private String ENDDE;

    @Column(columnDefinition = "varchar(400)")
    private String COMPANYNAME;

    @Column(columnDefinition = "varchar(100)")
    private String POSITION;

    @Column(columnDefinition = "varchar(400)")
    private String ASSIGNTASK;

    @Column(columnDefinition = "varchar(100)")
    private String DEVISION;

}
