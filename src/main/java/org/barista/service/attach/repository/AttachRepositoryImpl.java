package org.barista.service.attach.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.framework.base.BaseMap;
import org.barista.framework.constants.ColumnConstants;
import org.barista.service.attach.dto.AttachDto;
import org.barista.service.attach.entity.AttachEntity;
import org.barista.service.attach.entity.QAttachEntity;
import org.barista.service.board.entity.BoardEntity;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class AttachRepositoryImpl implements AttachRepositoryCustorm {

    private final JPAQueryFactory queryFactory;

    BaseMap<AttachEntity> baseMap = new BaseMap<AttachEntity>(AttachEntity.class, "attachEntity");

    @Override
    public AttachDto get(String id, Expression<?>... expressions) {
        return null;
    }

    @Override
    public Map<String, Object> getList(Object obj, Expression<?>... expressions) {
        return null;
    }

    @Override
    public List<AttachDto> getOnlyList(Object obj, Expression<?>... expressions) {
        return null;
    }
//
//    private List<OrderSpecifier> getOrderSpecifier(Sort sort) {
//        List<OrderSpecifier> orders = new ArrayList<>();
//        // Sort
//        sort.stream().forEach(order -> {
//            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
//            String prop = order.getProperty();
//            PathBuilder orderByExpression = new PathBuilder(AttachEntity.class, "attachEntity");
//            orders.add(new OrderSpecifier(direction, orderByExpression.get(prop)));
//        });
//        return orders;
//    }
//
//    private Expression<?>[] setSearchColumns(Expression<?>... expressions) {
//        return expressions.length == 0 ? new Expression[] {
//
//                Q_ATTACH_ENTITY.seqNo;
//
//
//                Q_BOARD_ENTITY.id
//                , Q_BOARD_ENTITY.instanceId
//                , Q_BOARD_ENTITY.content
//                , Q_BOARD_ENTITY.title
//                , Q_BOARD_ENTITY.isNotice
//                , Q_BOARD_ENTITY.isPublic
//                , Q_BOARD_ENTITY.delYn
//                , Q_BOARD_ENTITY.registDe
//                , Q_BOARD_ENTITY.modifyDe
//                , Q_BOARD_ENTITY.readCnt
//                , modifier.mberName.as(ColumnConstants.MODIFIER_NAME)
//                , register.mberName.as(ColumnConstants.REGISTER_NAME)
//                , ExpressionUtils.as(JPAExpressions.select(Q_CODE_ENTITY.name).from(Q_CODE_ENTITY).where(Q_BOARD_ENTITY.codeId.eq(Q_CODE_ENTITY.cd)), ColumnConstants.CODE_NAME)
//        } : expressions;
//    }

}
