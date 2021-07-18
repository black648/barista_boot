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
    @Column(columnDefinition = "varchar(50)")
    private String id;

    @Column(columnDefinition = "varchar(100)")
    private String name;
}
