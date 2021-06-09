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
    private String RESUMESN;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RNO;

    @Column(columnDefinition = "varchar(8)")
    private String BEGINDE;

    @Column(columnDefinition = "varchar(8)")
    private String ENDDE;

    @Column(columnDefinition = "varchar(400)")
    private String SCHOOL;

    @Column(columnDefinition = "varchar(200)")
    private String MAJOR;

    @Column(columnDefinition = "varchar(100)")
    private String DIVISION;

}
