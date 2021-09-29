package org.barista.service.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.service.member.entity.MemberEntity;

import java.util.Optional;

import static org.barista.service.member.entity.QMemberEntity.memberEntity;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public Optional<MemberEntity> get(String mberid) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(memberEntity)
                        .where(memberEntity.mberId.eq(mberid))
                        .fetchOne()
        );
    }
}
