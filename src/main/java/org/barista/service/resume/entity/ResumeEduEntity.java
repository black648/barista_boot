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
    @Column(columnDefinition = "varchar(20)")
    private String resumeSn;

    @Column(columnDefinition = "varchar(8)")
    private String beginDe;

    @Column(columnDefinition = "varchar(8)")
    private String endDe;

    @Column(columnDefinition = "varchar(400)")
    private String institution;

    @Column(columnDefinition = "varchar(400)")
    private String eduContent;

    @Column(columnDefinition = "varchar(50)")
    private String eduTime;

}
