package org.barista.service.board.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;
import org.barista.service.member.entity.MemberEntity;

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
    private String instanceId;

    //게시글 명
    @Column(columnDefinition = "varchar(100)")
    private String title;

    //내용
    @Column
    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="registerNo")
    private MemberEntity register;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="modifierNo")
    private MemberEntity modifier;

    //공지여부
    @Column(columnDefinition = "varchar(1)")
    private String isNotice;

    //공개여부
    @Column(columnDefinition = "varchar(1)")
    private String isPublic;

    //삭제여부
    @Column(columnDefinition = "varchar(1)")
    private String delYn;

    //조회수
    @Column(columnDefinition = "int")
    private Long readCnt;

    //분류코드
    @Column(columnDefinition = "varchar(20)")
    private String codeId;

    //게시판타입
    @Column(columnDefinition = "varchar(10)")
    private String boardType;

    //예비필드3
    @Column(columnDefinition = "varchar(100)")
    private String etc;
}
