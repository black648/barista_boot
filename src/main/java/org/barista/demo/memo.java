package org.barista.demo;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="memo_tbl")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class memo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 100, nullable = false)
    private String title1;

    @Column(length = 100, nullable = false)
    private String writer1;

    @Column(length = 100, nullable = false)
    private String content1;

}
