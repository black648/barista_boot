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
    private String resumesn;

    @Column(columnDefinition = "varchar(8)")
    private String beginde;

    @Column(columnDefinition = "varchar(8)")
    private String endde;

    @Column(columnDefinition = "varchar(400)")
    private String institution;

    @Column(columnDefinition = "varchar(400)")
    private String educontent;

    @Column(columnDefinition = "varchar(50)")
    private String edutime;

}
