package org.barista.framework.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
//@NoArgsConstructor //기본 생성자를 생성하여 주석처리.
@AllArgsConstructor
public abstract class BaseEntity {

    @CreatedDate
    @Column(columnDefinition = "date")
    private LocalDateTime registDe;

    @LastModifiedDate
    @Column(columnDefinition = "date")
    private LocalDateTime modifyDe;

    //아래 메서드는 @AllArgsConstructor 과 동일하다
//    public BaseEntity(LocalDateTime registDe, LocalDateTime modifyDe) {
//        this.registDe = registDe;
//        this.modifyDe = modifyDe;
//    }

    public BaseEntity() {
        this.registDe = LocalDateTime.now();
        this.modifyDe = LocalDateTime.now();
    }

}
