package org.barista.service.resume.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="resumequal")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeQualEntity  implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(100)")
    private String RESUMESN;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RNO;

    @Column(columnDefinition = "varchar(400)")
    private String QUALNAME;

    @Column(columnDefinition = "varchar(100)")
    private String ISSUENO;

    @Column(columnDefinition = "varchar(400)")
    private String INSTITUTION;

    @Column(columnDefinition = "varchar(8)")
    private String ISSUEDE;
}
