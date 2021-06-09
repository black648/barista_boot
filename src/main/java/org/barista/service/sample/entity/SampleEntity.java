package org.barista.service.sample.entity;

import lombok.*;
import org.barista.framework.base.BaseEntity;

import javax.persistence.*;


/*
@Entity - Entity클래스임을 명시합니다.
@Table(name = "category") - 매핑할 테이블 명을 지정합니다.
@Getter / @Setter - getters/setters를 만들어주는 롬복(Lombok) 애노테이션 입니다. JPA와는 별개의 애노테이션 입니다. 자세한 내용은 다른 포스팅을 참고해주시기 바랍니다. ☞ 롬복(Lombok) 애노테이션 사용하기
@Id - 기본키임을 나타냅니다. 모든 Entity클래스는 @Id설정이 필요합니다. 기본키가 복합키로 된 경우는 @Embeddedid를 사용합니다.
@GeneratedValue(strategy = GenerationType.IDENTITY) - JPA가 기본키 생성을 하도록 합니다.
@Column -  Entity클래스의 모든 필드는 데이터베이스의 컬럼과 매핑되어 따로 명시하지 않아도 됩니다. 하지만 매핑될 컬럼명이 다르거나, default값이 다른경우에 사용합니다. (이름은 카멜표기법이 소문자 스네이크 표기법으로 전환되고, length는 255, nullable은 true가 default 값입니다.)
@ManyToOne - 다른 Entity클래스와의 외래키 다대일(N:1)관계를 명시합니다.
@JoinColumn - name에 명시한 category_id라는 컬럼명으로Category에 대한 외래키 설정이 됩니다. 참조 되는 컬럼은 Catrgory Entity클래스에서 @Id가 명시된 필드입니다.
@OneToMany - 다른 Entity클래스와 일대다(1:N)관계를 명시합니다. mappedBy에는 제네릭스로 명시된 Cart Entity가 외래키 설정에서 사용한 참조변수 이름입니다. 반대편이 Many 설정일 경우에는 반드시 컬렉션프레임워크(List나 Set)을 사용합니다.  방향성에 대한 자세한 내용은 다음 포스팅을 참고하시기 바랍니다. ☞ JPA Entity간의 방향 설정하기
 */

@Entity
@Table(name="sample_tbl")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleEntity extends BaseEntity {

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
