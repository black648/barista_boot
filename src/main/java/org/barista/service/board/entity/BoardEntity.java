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
    @Column(columnDefinition = "varchar(50)")
    private String id;

    //게시판 번호(형태)
    @Column(columnDefinition = "varchar(50)")
    private String instanceid;

    //게시글 명
    @Column(columnDefinition = "varchar(100)")
    private String title;

    //내용
    @Column
    @Lob
    private String content;

    //등록자
    @Column(columnDefinition = "int")
    private Long registerno;

    //등록자명
    @Column(columnDefinition = "varchar(100)")
    private String registername;

    //수정자
    @Column(columnDefinition = "int")
    private Long modifierno;

    //수정자명
    @Column(columnDefinition = "varchar(100)")
    private String modifiername;

    //공지여부
    @Column(columnDefinition = "varchar(1)")
    private String isnotice;

    //공개여부
    @Column(columnDefinition = "varchar(1)")
    private String ispublic;

    //삭제여부
    @Column(columnDefinition = "varchar(1)")
    private String delyn;

    //조회수
    @Column(columnDefinition = "int")
    private Long readcnt;

    //예비필드1
    @Column(columnDefinition = "varchar(100)")
    private String etc1;

    //예비필드2
    @Column(columnDefinition = "varchar(100)")
    private String etc2;

    //예비필드3
    @Column(columnDefinition = "varchar(100)")
    private String etc3;

    //파일 그룹핑넘버
    @Column(columnDefinition = "int")
    private Long filegrpno;

}
