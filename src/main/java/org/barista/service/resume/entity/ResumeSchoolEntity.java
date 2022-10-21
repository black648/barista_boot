package org.barista.service.resume.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="resumeschool")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeSchoolEntity  implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(20)")
    private String resumeSn;

    @Column(columnDefinition = "varchar(8)")
    private String beginDe;

    @Column(columnDefinition = "varchar(8)")
    private String endDe;

    @Column(columnDefinition = "varchar(100)")
    private String school;

    @Column(columnDefinition = "varchar(100)")
    private String major;

    @Column(columnDefinition = "varchar(50)")
    private String division;

}
