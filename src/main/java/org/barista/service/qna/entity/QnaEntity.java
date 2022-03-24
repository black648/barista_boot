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
    @Column(columnDefinition = "varchar(50)")
    private String id;

    @Column(columnDefinition = "varchar(20)")
    private String registerNo;

    @CreatedDate
    @Column(columnDefinition = "date")
    private LocalDateTime answerDe;

    @Column(columnDefinition = "varchar(400)")
    private String title;

    @Column
    @Lob
    private String content;

    @Column(columnDefinition = "varchar(1)")
    private String deleteAt;

    @Column(columnDefinition = "varchar(1)")
    private String offAt;

    @Column(columnDefinition = "varchar(300)")
    private String email;

    @Column(columnDefinition = "varchar(40)")
    private String middleCode;

    @Column(columnDefinition = "varchar(40)")
    private String rowCode;

    @Column(columnDefinition = "varchar(4)")
    private String state;

}
