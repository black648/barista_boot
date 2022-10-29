package org.barista.service.common.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="code")
@ToString
@Getter
@Setter
@NoArgsConstructor
@IdClass(CodePK.class)
public class CodeEntity extends BaseEntity implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(5)")
    private String grpCd;

    @Id
    @Column(columnDefinition = "varchar(20)")
    private String cd;

    @Column(columnDefinition = "varchar(20)")
    private String pcd;

    //레벨
    @Column(columnDefinition = "smallint")
    private int level;

    //코드명
    @Column(columnDefinition = "varchar(20)")
    private String name;

    //코드설명
    @Column(columnDefinition = "varchar(300)")
    private String dscr;

    //사용여부
    @Column(columnDefinition = "varchar(1) default 'Y' not null")
    private String useAble;

    //정렬순서
    @Column(columnDefinition = "smallint")
    private int orderNo;

    @Column(columnDefinition = "varchar(12)")
    private String strDe;

    @Column(columnDefinition = "varchar(12)")
    private String endDe;

    //생성자
    @Column(columnDefinition = "varchar(20)")
    private String registerNo;

    //수정자
    @Column(columnDefinition = "varchar(20)")
    private String modifierNo;

    //매칭코드
    @Column(columnDefinition = "varchar(12)")
    private String mappingCd;

    //매칭코드명
    @Column(columnDefinition = "varchar(100)")
    private String mappingName;

    //사용자정의1
    @Column(columnDefinition = "varchar(500)")
    private String userDef1;

    //사용자정의2
    @Column(columnDefinition = "varchar(500)")
    private String userDef2;

    //사용자정의3
    @Column(columnDefinition = "varchar(500)")
    private String userDef3;

    @Transient //컬럼생성 x
    private Collection<CodeEntity> codeList;

    @Builder
    public CodeEntity(String grpCd, String cd, String pcd, int level, String name, String dscr, String useAble, int orderNo, String strDe, String endDe, String registerNo, String modifierNo, String mappingCd, String mappingName, String userDef1, String userDef2, String userDef3) {
        super();
        this.grpCd = grpCd;
        this.cd = cd;
        this.pcd = pcd;
        this.level = level;
        this.name = name;
        this.dscr = dscr;
        this.useAble = useAble;
        this.orderNo = orderNo;
        this.strDe = strDe;
        this.endDe = endDe;
        this.registerNo = registerNo;
        this.modifierNo = modifierNo;
        this.mappingCd = mappingCd;
        this.mappingName = mappingName;
        this.userDef1 = userDef1;
        this.userDef2 = userDef2;
        this.userDef3 = userDef3;
    }
}
