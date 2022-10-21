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
    @Column(columnDefinition = "varchar(20)")
    private String resumeSn;

    @Column(columnDefinition = "varchar(400)")
    private String qualName;

    @Column(columnDefinition = "varchar(100)")
    private String issueNo;

    @Column(columnDefinition = "varchar(400)")
    private String institution;

    @Column(columnDefinition = "varchar(8)")
    private String issueDe;
}
