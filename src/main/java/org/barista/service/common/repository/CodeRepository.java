package org.barista.service.common.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.service.common.entity.CodeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.barista.service.common.entity.QCodeEntity.codeEntity;

@RequiredArgsConstructor
@Repository
public class CodeRepository {
    private final JPAQueryFactory queryFactory;

    public List<CodeEntity> findByGrpcd(String grpcd) {
        return queryFactory.selectFrom(codeEntity)
                .where(codeEntity.grpcd.eq(grpcd))
                .where(codeEntity.useable.eq("T"))
                .fetch();
    }
}
