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

import static org.barista.service.board.entity.QBoardEntity.boardEntity;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public List<BoardEntity> getList(Map<String, Object> paramMap, Sort sort) {
        return queryFactory.selectFrom(boardEntity)
                .where(
                        idEq((String) paramMap.get("id")),
                        instanceIdEq((String) paramMap.get("instanceId")),
                        contentLike((String) paramMap.get("content")),
                        titleLike((String) paramMap.get("title")),
                        registerDeTo((String) paramMap.get("registerDeTo")),
                        registerDeFrom((String) paramMap.get("registerDeFrom")),
                        isPublicEq((String) paramMap.get("isPublic")),
                        isNoticeEq((String) paramMap.get("isNotice")),
                        delYnEq((String) paramMap.get("delYn"))
                )
                .orderBy(getOrderSpecifier(sort).stream().toArray(OrderSpecifier[]::new))
                .offset(setPage((String) paramMap.get("page")))
                .limit(setPageSize((String) paramMap.get("pageSize")))
                .fetch();
    }

    // 조건부
    private BooleanExpression idEq(String id) {
        return id != null ? boardEntity.id.eq(id) : null;
    }

    private BooleanExpression instanceIdEq(String instanceid) {
        return instanceid != null ? boardEntity.instanceId.eq(instanceid) : null;
    }
//    검색 영역
    private BooleanExpression contentLike(String content) {
        return content != null ? boardEntity.content.like(content) : null;
    }

    private BooleanExpression titleLike(String title) {
        return title != null ? boardEntity.title.like(title) : null;
    }

    private BooleanExpression registerDeTo(String registerDeTo) {
        return ObjectUtil.isNotEmpty(registerDeTo) ? boardEntity.registDe.after(LocalDateTime.parse(registerDeTo)) : null;
    }

    private BooleanExpression registerDeFrom(String registerDeFrom) {
        return ObjectUtil.isNotEmpty(registerDeFrom) ? boardEntity.registDe.before(LocalDateTime.parse(registerDeFrom)) : null;
    }

    private BooleanExpression isPublicEq(String isPublic) {
        return isPublic != null ? boardEntity.isPublic.eq(isPublic) : null;
    }

    private BooleanExpression isNoticeEq(String isNotice) {
        return isNotice != null ? boardEntity.isNotice.eq(isNotice) : null;
    }

    private BooleanExpression delYnEq(String delYn) {
        return delYn != null ? boardEntity.delYn.eq(delYn) : null;
    }

    private int setPage(String page) {
        return page != null ? Integer.parseInt(page) : 0;
    }

    private int setPageSize(String pageSize) {
        return pageSize != null ? Integer.parseInt(pageSize) : 20;
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
