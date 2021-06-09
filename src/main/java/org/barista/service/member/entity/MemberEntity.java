package org.barista.service.member.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity extends BaseEntity implements Serializable {

    @Id
    @Column(columnDefinition = "int")
    private Long MBERNO;

    @Column(columnDefinition = "varchar(100)")
    private String MBERNAME;

    @Column(columnDefinition = "varchar(100)")
    private String MBERID;

    @Column(columnDefinition = "varchar(100)")
    private String PASSWORD;

    @Column(columnDefinition = "varchar(100)")
    private String MBERPHONE;

    @Column(columnDefinition = "varchar(2000)")
    private String ADDRESS1;

    @Column(columnDefinition = "varchar(100)")
    private String ADDRESS2;

    @Column(columnDefinition = "varchar(40)")
    private String MBERSE;

    @Column(columnDefinition = "varchar(300)")
    private String EMAIL;

    @Column(columnDefinition = "varchar(50)")
    private String SESSIONKEY;

    @CreatedDate
    @Column(columnDefinition = "date")
    private LocalDateTime SESSIONLIMIT;

    /*
    MBER_NO      NUMBER(20)                  not null
        constraint MEMBER_PK
            primary key,
    MBER_NAME    varchar(400)               not null,
    MBER_ID      varchar(400)               not null,
    PASSWORD     varchar(400)               not null,
    MBER_PHONE   varchar(300),
    ADDRESS1     varchar(2000),
    ADDRESS2     varchar(2000),
    MBER_SE      varchar(40)                not null,
    CRE_DE       DATE,
    UPD_DE       DATE,
    EMAIL        varchar(300),
    SESSIONKEY   varchar(50) default 'none' not null,
    SESSIONLIMIT DATE
     */
}
