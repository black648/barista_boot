package org.barista.service.resume.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="resumeedue")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeEduEntity extends BaseEntity  implements Serializable {


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
    private String INSTITUTION;

    @Column(columnDefinition = "varchar(400)")
    private String EDUCONTENT;

    @Column(columnDefinition = "varchar(50)")
    private String EDUTIME;

}
