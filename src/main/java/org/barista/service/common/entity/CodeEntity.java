package org.barista.service.common.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name="code")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CodePK.class)
public class CodeEntity extends BaseEntity  implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(5)")
    private String grpcd;

    @Id
    @Column(columnDefinition = "varchar(20)")
    private String cd;

    @Column(columnDefinition = "varchar(20)")
    private String pcd;

    //레벨
    @Column(columnDefinition = "smallint")
    private int lvl;

    //코드명
    @Column(columnDefinition = "varchar(20)")
    private String cdname;

    //코드설명
    @Column(columnDefinition = "varchar(300)")
    private String cddscr;

    //사용여부
    @Column(columnDefinition = "varchar(1) default 'Y' not null")
    private String useable;

    //정렬순서
    @Column(columnDefinition = "smallint")
    private int orderno;

    //시작일
    @Column(columnDefinition = "date")
    private LocalDateTime strdate;

    //종료일
    @Column(columnDefinition = "date")
    private LocalDateTime enddate;

    //생성자
    @Column(columnDefinition = "int")
    private Long registerno;

    //수정자
    @Column(columnDefinition = "int")
    private Long modifierno;

    //매칭코드
    @Column(columnDefinition = "varchar(12)")
    private String mappcd;

    //매칭코드명
    @Column(columnDefinition = "varchar(100)")
    private String mappcdname;

    //사용자정의1
    @Column(columnDefinition = "varchar(500)")
    private String userdef1;

    //사용자정의2
    @Column(columnDefinition = "varchar(500)")
    private String userdef2;

    //사용자정의3
    @Column(columnDefinition = "varchar(500)")
    private String userdef3;

    @Transient //컬럼생성 x
    private Collection<CodeEntity> codeList;

}
