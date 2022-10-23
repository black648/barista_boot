package org.barista.service.board.repository;

import com.querydsl.core.support.QueryBase;
import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAInsertClause;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;
import org.barista.framework.base.BaseMap;
import org.barista.framework.constants.ColumnConstants;
import org.barista.framework.constants.CommonConstants;
import org.barista.framework.utils.RepositoryUtil;
import org.barista.framework.utils.Utils;
import org.barista.service.board.dto.BoardDto;
import org.barista.service.board.dto.BoardSearchDto;
import org.barista.service.board.entity.BoardEntity;
import org.barista.service.member.entity.QMemberEntity;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    BaseMap<BoardEntity> baseMap = new BaseMap<>(BoardEntity.class, "boardEntity");

    QMemberEntity register = Q_MEMBER_ENTITY;
    QMemberEntity modifier = Q_MEMBER_ENTITY;

    @Override
    public BoardDto get(String id, Expression<?>... expressions) {
        return queryFactory.select(Projections.fields(BoardDto.class, setSearchColumns(expressions)))
                .from(Q_BOARD_ENTITY)
                .where( RepositoryUtil.equals(id, Q_BOARD_ENTITY.id),
                        RepositoryUtil.equals("N", Q_BOARD_ENTITY.delYn))
                .leftJoin(Q_BOARD_ENTITY.register, register)
                .leftJoin(Q_BOARD_ENTITY.modifier, modifier)
                .fetchOne();
    }

    @Override
    public List<BoardDto> getJustList(Object obj, Expression<?>... expressions) {
        BoardSearchDto searchDto = (BoardSearchDto) obj;
        searchDto.setSort(searchDto.getOrder(), searchDto.getOrderProperty());

//        return getListSQL(getBaseSQL(searchDto, expressions), searchDto).fetch();

        return getListSQL(getBaseSQL(searchDto, expressions), searchDto).fetch();
    }

    @Override
    public Map<String, Object> getList(Object obj, Expression<?>... expressions) {

        BoardSearchDto searchDto = (BoardSearchDto) obj;
        searchDto.setSort(searchDto.getOrder(), searchDto.getOrderProperty());

        QueryBase<JPAQuery<BoardDto>> query = getBaseSQL(searchDto, expressions);

        return Map.of(
                CommonConstants.CONST_LIST, getListSQL(query, searchDto).fetch(),
                CommonConstants.CONST_LIST_COUNT, query.distinct().fetchCount());
    }

    @Transactional
    public void update(String UID, Map<String, Object> paramMap) {
        JPAUpdateClause query = queryFactory.update(Q_BOARD_ENTITY).where(Q_BOARD_ENTITY.id.eq("12398sdwhasdfljkfdsa"));
        baseMap.setQMap(paramMap).forEach((key, value) -> query.set(key, value));
        query.execute();
    }

    //Method threw 'java.lang.NullPointerException' exception. Cannot evaluate com.querydsl.jpa.impl.JPAInsertClause.toString()
    @Transactional
    public void saveD() {
        JPAInsertClause query = queryFactory.insert(Q_BOARD_ENTITY)
            .columns(Q_BOARD_ENTITY.id, Q_BOARD_ENTITY.title, Q_BOARD_ENTITY.content )
                .values(Utils.getID(), "타이틀이당", "내용이당");
        query.execute();
    }

    private JPAQuery getListSQL (QueryBase<JPAQuery<BoardDto>> queryBase, BoardSearchDto searchDto) {
        return queryBase
                .orderBy(RepositoryUtil.getOrderSpecifier(searchDto.getSort()
                        , new PathBuilder(BoardEntity.class, "boardEntity")).stream().toArray(OrderSpecifier[]::new))
                .offset(RepositoryUtil.setPage(searchDto.getPage()))
                .limit(RepositoryUtil.setPageSize(searchDto.getPageSize()));
    }
    private QueryBase<JPAQuery<BoardDto>> getBaseSQL(BoardSearchDto searchDto, Expression<?>... expressions) {
        return queryFactory.select(Projections.fields(BoardDto.class, setSearchColumns(expressions)))
                .from(Q_BOARD_ENTITY)
                .where(   RepositoryUtil.equals(searchDto.getId(), Q_BOARD_ENTITY.id)
                        , RepositoryUtil.equals(searchDto.getInstanceId(), Q_BOARD_ENTITY.instanceId)
                        , RepositoryUtil.like(searchDto.getContent(), Q_BOARD_ENTITY.content)
                        , RepositoryUtil.like(searchDto.getTitle(), Q_BOARD_ENTITY.title)
                        , RepositoryUtil.before(searchDto.getRegisterDeFrom(), Q_BOARD_ENTITY.registDe)
                        , RepositoryUtil.before(searchDto.getRegisterDeTo(), Q_BOARD_ENTITY.registDe)
                        , RepositoryUtil.equals(searchDto.getIsPublic(), Q_BOARD_ENTITY.isPublic)
                        , RepositoryUtil.equals(searchDto.getIsNotice(), Q_BOARD_ENTITY.isNotice)
                        , RepositoryUtil.equals(searchDto.getDelYn(), Q_BOARD_ENTITY.delYn))
                .leftJoin(Q_BOARD_ENTITY.register, register)
                .leftJoin(Q_BOARD_ENTITY.modifier, modifier);
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

    private Expression<?>[] setSearchColumns(Expression<?>... expressions) {
        return expressions.length == 0 ? new Expression[] {
                Q_BOARD_ENTITY.id
                , Q_BOARD_ENTITY.instanceId
                , Q_BOARD_ENTITY.content
                , Q_BOARD_ENTITY.title
                , Q_BOARD_ENTITY.isNotice
                , Q_BOARD_ENTITY.isPublic
                , Q_BOARD_ENTITY.delYn
                , Q_BOARD_ENTITY.registDe
                , Q_BOARD_ENTITY.modifyDe
                , Q_BOARD_ENTITY.readCnt
                , modifier.mberName.as(ColumnConstants.MODIFIER_NAME)
                , register.mberName.as(ColumnConstants.REGISTER_NAME)
                , ExpressionUtils.as(JPAExpressions.select(Q_CODE_ENTITY.name).from(Q_CODE_ENTITY).where(Q_BOARD_ENTITY.codeId.eq(Q_CODE_ENTITY.cd)), ColumnConstants.CODE_NAME)
        } : expressions;
    }
}
