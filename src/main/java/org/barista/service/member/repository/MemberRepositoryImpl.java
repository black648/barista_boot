package org.barista.service.member.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.framework.utils.ObjectUtil;
import org.barista.service.member.entity.MemberEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.barista.service.board.entity.QBoardEntity.boardEntity;
import static org.barista.service.member.entity.QMemberEntity.memberEntity;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public Optional<MemberEntity> get(String mberId) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(memberEntity)
                        .where(mberIdEq(mberId))
                        .fetchOne()
        );
    }

    private BooleanExpression mberIdEq(String mberId) {
        return mberId != null ? memberEntity.mberId.eq(mberId) : null;
    }

    private BooleanExpression mberNameLike(String mberName) {
        return mberName != null ? memberEntity.mberName.like(mberName) : null;
    }
    //    검색 영역
    private BooleanExpression emailEq(String email) {
        return email != null ? memberEntity.email.like(email) : null;
    }

    private BooleanExpression deTo(String registDeTo, int searchDateType) {

        return ObjectUtil.isNotEmpty(registDeTo) ? searchDateType == 1
                ? memberEntity.registDe.after(LocalDateTime.parse(registDeTo))
                    : memberEntity.modifyDe.after(LocalDateTime.parse(registDeTo))
                : null;
    }

    private BooleanExpression deFrom(String registDeFrom, int searchDateType) {
        return ObjectUtil.isNotEmpty(registDeFrom) ? searchDateType == 1
                ? memberEntity.registDe.before(LocalDateTime.parse(registDeFrom))
                    : memberEntity.modifyDe.before(LocalDateTime.parse(registDeFrom))
                : null;
    }


}
