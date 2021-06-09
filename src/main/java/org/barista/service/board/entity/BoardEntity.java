package org.barista.service.board.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="board")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    //게시판 번호(형태)
    @Column(columnDefinition = "smallint")
    private int INSTANCEID;

    //게시글 명
    @Column(columnDefinition = "varchar(100)")
    private String TITLE;

    //내용
    @Column
    @Lob
    private String CONTENT;

    //등록자
    @Column(columnDefinition = "int")
    private Long REGISTERNO;

    //등록자명
    @Column(columnDefinition = "varchar(100)")
    private String REGISTERNAME;

    //수정자
    @Column(columnDefinition = "int")
    private Long MODIFIERNO;

    //수정자명
    @Column(columnDefinition = "varchar(100)")
    private String MODIFIERNAME;

    //공지여부
    @Column(columnDefinition = "varchar(100)")
    private String ISNOTICE;

    //공개여부
    @Column(columnDefinition = "varchar(1)")
    private String ISPUBLIC;

    //삭제여부
    @Column(columnDefinition = "varchar(1)")
    private String DELYN;

    //조회수
    @Column(columnDefinition = "int")
    private Long READCNT;

    //예비필드1
    @Column(columnDefinition = "varchar(100)")
    private String ETC1;

    //예비필드2
    @Column(columnDefinition = "varchar(100)")
    private String ETC2;

    //예비필드3
    @Column(columnDefinition = "varchar(100)")
    private String ETC3;

    //파일 그룹핑넘버
    @Column(columnDefinition = "int")
    private Long FILEGRPNO;

}
