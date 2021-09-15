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

    @Column(columnDefinition = "varchar(400)")
    private String qualname;

    @Column(columnDefinition = "varchar(100)")
    private String issueno;

    @Column(columnDefinition = "varchar(400)")
    private String institution;

    @Column(columnDefinition = "varchar(8)")
    private String issuede;
}
