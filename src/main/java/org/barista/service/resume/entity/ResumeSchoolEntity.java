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
    @Column(columnDefinition = "varchar(100)")
    private String resumesn;

    @Column(columnDefinition = "varchar(8)")
    private String beginde;

    @Column(columnDefinition = "varchar(8)")
    private String endde;

    @Column(columnDefinition = "varchar(400)")
    private String school;

    @Column(columnDefinition = "varchar(200)")
    private String major;

    @Column(columnDefinition = "varchar(100)")
    private String division;

}
