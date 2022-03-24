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
    private Long id;

    @Column(columnDefinition = "varchar(100)")
    private String name;
}
