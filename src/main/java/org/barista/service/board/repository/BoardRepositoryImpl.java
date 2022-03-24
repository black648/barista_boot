package org.barista.service.board.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.framework.constants.ColumnConstants;
import org.barista.framework.utils.ObjectUtil;
import org.barista.service.board.dto.BoardDto;
import org.barista.service.board.dto.BoardSearchDto;
import org.barista.service.board.entity.BoardEntity;
import org.barista.service.member.entity.QMemberEntity;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.barista.service.board.entity.QBoardEntity.boardEntity;
import static org.barista.service.member.entity.QMemberEntity.memberEntity;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    QMemberEntity register = memberEntity;
    QMemberEntity modifier = memberEntity;

    public BoardDto get(String id) {
        return get(id, setAllSearchColumn());
    }

    public BoardDto get(String id, Expression<?>... expressions) {
        return queryFactory.select(Projections.fields(BoardDto.class, expressions))
                .from(boardEntity)
                .where(
                        idEq(id),
                        delYnEq("N")
                )
                .leftJoin(boardEntity.register, register)
                .leftJoin(boardEntity.modifier, modifier)
                .fetchOne();
    }

    public List<BoardDto> getList(Object obj) {
        return getList(obj, setAllSearchColumn());
    }

    public List<BoardDto> getList(Object obj, Expression<?>... expressions) {
        BoardSearchDto searchDto = (BoardSearchDto) obj;
        searchDto.setSort(searchDto.getOrder(), searchDto.getOrderProperty());

        return queryFactory.select(Projections.fields(BoardDto.class, expressions))
                .from(boardEntity)
                .where(
                        idEq(searchDto.getId()),
                        instanceIdEq(searchDto.getInstanceId()),
                        contentLike(searchDto.getContent()),
                        titleLike(searchDto.getTitle()),
                        registerDeTo(searchDto.getRegisterDeTo()),
                        registerDeFrom(searchDto.getRegisterDeFrom()),
                        isPublicEq(searchDto.getIsPublic()),
                        isNoticeEq(searchDto.getIsNotice()),
                        delYnEq(searchDto.getDelYn())
                )
                .leftJoin(boardEntity.register, register)
                .leftJoin(boardEntity.modifier, modifier)
                .orderBy(getOrderSpecifier(searchDto.getSort()).stream().toArray(OrderSpecifier[]::new))
                .offset(setPage(searchDto.getPage()))
                .limit(setPageSize(searchDto.getPageSize()))
                .fetch();
    }

    // 조건부
    private BooleanExpression idEq(String id) {
        return id != null ? boardEntity.id.eq(id) : null;
    }

    private BooleanExpression instanceIdEq(String instanceId) {
        return instanceId != null ? boardEntity.instanceId.eq(instanceId) : null;
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

    private Expression<?>[] setAllSearchColumn() {
        return new Expression[] {
                boardEntity.id
                , boardEntity.instanceId
                , boardEntity.content
                , boardEntity.title
                , boardEntity.isNotice
                , boardEntity.isPublic
                , boardEntity.delYn
                , boardEntity.registDe
                , boardEntity.modifyDe
                , boardEntity.readCnt
                , modifier.mberName.as(ColumnConstants.MODIFIER_NAME)
                , register.mberName.as(ColumnConstants.REGISTER_NAME)
        };
    }
}
