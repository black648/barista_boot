package org.barista.service.board.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="boardinstance")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardInstanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long INSTANCEID;

    //게시판 번호(형태)
    @Column(columnDefinition = "varchar(20)")
    private String INSTANCENAME;
}
