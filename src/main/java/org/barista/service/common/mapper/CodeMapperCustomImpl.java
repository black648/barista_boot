package org.barista.service.common.mapper;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CodeMapperCustomImpl implements CodeMapperCustom{

    private final JPAQueryFactory queryFactory;

    //예시
//    @Override
//    public List<Academy> findByName(String name) {
//        return queryFactory.selectFrom(academy)
//                .where(academy.name.eq(name))
//                .fetch();
//    }

}
