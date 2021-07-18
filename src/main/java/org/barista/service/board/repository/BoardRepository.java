package org.barista.service.board.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.framework.utils.ObjectUtil;
import org.barista.service.board.entity.BoardEntity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.barista.service.board.entity.QBoardEntity.boardEntity;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final JPAQueryFactory queryFactory;

    public List<BoardEntity> getList(Map<String, Object> paramMap, Sort sort) {
        return queryFactory.selectFrom(boardEntity)
                .where(
                        idEq((String) paramMap.get("id")),
                        instanceIdEq((String) paramMap.get("instanceid")),
                        contentEq((String) paramMap.get("content")),
                        titleEq((String) paramMap.get("title")),
                        registerDeTo((String) paramMap.get("title")),
                        registerDeFrom((String) paramMap.get("title")),
                        isPublicEq((String) paramMap.get("title")),
                        isNoticeEq((String) paramMap.get("title")),
                        delYnEq((String) paramMap.get("title"))
                )
                .orderBy(getOrderSpecifier(sort).stream().toArray(OrderSpecifier[]::new))
                .fetch();
    }

    // 조건부
    private BooleanExpression idEq(String id) {
        return id != null ? boardEntity.id.eq(id) : null;
    }

    private BooleanExpression instanceIdEq(String instanceid) {
        return instanceid != null ? boardEntity.instanceid.eq(instanceid) : null;
    }
//    검색 영역
    private BooleanExpression contentEq(String content) {
        return content != null ? boardEntity.content.like(content) : null;
    }

    private BooleanExpression titleEq(String title) {
        return title != null ? boardEntity.title.like(title) : null;
    }

    private BooleanExpression registerDeTo(String registerDeTo) {
        return ObjectUtil.isNotEmpty(registerDeTo) ? boardEntity.registde.after(LocalDateTime.parse(registerDeTo)) : null;
    }

    private BooleanExpression registerDeFrom(String registerDeFrom) {
        return ObjectUtil.isNotEmpty(registerDeFrom) ? boardEntity.registde.before(LocalDateTime.parse(registerDeFrom)) : null;
    }

    private BooleanExpression isPublicEq(String isPublic) {
        return isPublic != null ? boardEntity.ispublic.eq(isPublic) : null;
    }

    private BooleanExpression isNoticeEq(String isNotice) {
        return isNotice != null ? boardEntity.isnotice.eq(isNotice) : null;
    }

    private BooleanExpression delYnEq(String delYn) {
        return delYn != null ? boardEntity.delyn.eq(delYn) : null;
    }


    //order by
    private List<OrderSpecifier> getOrderSpecifier(Sort sort) {
        List<OrderSpecifier> orders = new ArrayList<>();
        // Sort
        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            String prop = order.getProperty();
            PathBuilder orderByExpression = new PathBuilder(BoardEntity.class, "boardEntity");
            orders.add(new OrderSpecifier(direction, orderByExpression.get(prop)));
        });
        return orders;
    }
}
