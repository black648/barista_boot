package org.barista.service.qna.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="qna")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QnaEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qno;

    @Column(columnDefinition = "int")
    private Long REGISTERNO;

    @CreatedDate
    @Column(columnDefinition = "date")
    private LocalDateTime ANSWERDE;

    @Column(columnDefinition = "varchar(400)")
    private String TITLE;

    @Column
    @Lob
    private String CONTENT;

    @Column(columnDefinition = "varchar(4)")
    private String DELETEAT;

    @Column(columnDefinition = "varchar(4)")
    private String OFFAT;

    @Column(columnDefinition = "varchar(300)")
    private String EMAIL;

    @Column(columnDefinition = "varchar(40)")
    private String MIDDLECODE;

    @Column(columnDefinition = "varchar(40)")
    private String ROWCODE;

    @Column(columnDefinition = "varchar(4)")
    private String STATE;

}
