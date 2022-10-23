package org.barista.service.common.repository;


import com.querydsl.core.support.QueryBase;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.framework.constants.CommonConstants;
import org.barista.framework.utils.RepositoryUtil;
import org.barista.service.common.dto.CodeDto;
import org.barista.service.common.dto.CodeSearchDto;
import org.barista.service.common.entity.CodeEntity;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.barista.service.common.entity.QCodeEntity.codeEntity;

@RequiredArgsConstructor
public class CodeRepositoryImpl implements CodeRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public CodeDto get(String id, Expression<?>... expressions) {
        return queryFactory.select(Projections.fields(CodeDto.class, setSearchColumns(expressions)))
                .from(codeEntity)
                .where( cdEq((String) id), useableEq())
                .fetchOne();
    }

    @Override
    public List<CodeDto> getJustList(Object obj, Expression<?>... expressions) {
        CodeSearchDto searchDto = (CodeSearchDto) obj;
        return getListSQL(getBaseSQL(searchDto, expressions), searchDto).fetch();
    }

    @Override
    public Map<String, Object> getList(Object obj, Expression<?>... expressions) {
        CodeSearchDto searchDto = (CodeSearchDto) obj;
        QueryBase<JPAQuery<CodeDto>> query = getBaseSQL(searchDto, expressions);

        return Map.of(
                CommonConstants.CONST_LIST, getListSQL(query, searchDto).fetch(),
                CommonConstants.CONST_LIST_COUNT, query.distinct().fetchCount());

    }

    public List<CodeEntity> getAll(Map<String, Object> paramMap, Sort sort) {
        return queryFactory.selectFrom(codeEntity)
                .where(
                        grpCdEq((String) paramMap.get("grpCd")),
                        cdEq((String) paramMap.get("cd")),
                        pcdEq((String) paramMap.get("pcd")),
                        levelEq((Integer) paramMap.get("level")),
                        useableEq()
                )
                .orderBy(getOrderSpecifier(sort).stream().toArray(OrderSpecifier[]::new))
                .fetch();
    }

    private JPAQuery getListSQL (QueryBase<JPAQuery<CodeDto>> queryBase, CodeSearchDto searchDto) {
        return queryBase.orderBy(RepositoryUtil.getOrderSpecifier(searchDto.getSort()
                        , new PathBuilder(CodeEntity.class, "codeEntity")).stream().toArray(OrderSpecifier[]::new));
    }
    private QueryBase<JPAQuery<CodeDto>> getBaseSQL(CodeSearchDto searchDto, Expression<?>... expressions) {
        return queryFactory.select(Projections.fields(CodeDto.class, setSearchColumns(expressions)))
                .from(Q_CODE_ENTITY)
                .where(   RepositoryUtil.equals(searchDto.getGrpCd(), Q_CODE_ENTITY.grpCd)
                        , RepositoryUtil.equals(searchDto.getCd(), Q_CODE_ENTITY.cd)
                        , RepositoryUtil.equals(searchDto.getPcd(), Q_CODE_ENTITY.pcd)
                        , RepositoryUtil.equalsNumber(searchDto.getLevel(), Q_CODE_ENTITY.level)
                        , RepositoryUtil.equals("T", Q_CODE_ENTITY.useAble));
    }


    // 조건부
    private BooleanExpression grpCdEq(String grpCd) {
        return grpCd != null ? codeEntity.grpCd.eq(grpCd) : null;
    }

    private BooleanExpression cdEq(String cd) {
        return cd != null ? codeEntity.cd.eq(cd) : null;
    }

    private BooleanExpression pcdEq(String pcd) {
        return pcd != null ? codeEntity.pcd.eq(pcd) : null;
    }

    private BooleanExpression levelEq(int level) {
        return level != 0 ? codeEntity.level.eq(level) : null;
    }

    private BooleanExpression useableEq() {
        return codeEntity.useAble.eq("T");
    }

    //order by
    private List<OrderSpecifier> getOrderSpecifier(Sort sort) {
        List<OrderSpecifier> orders = new ArrayList<>();
        // Sort
        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            String prop = order.getProperty();
            PathBuilder orderByExpression = new PathBuilder(CodeEntity.class, "codeEntity");
            orders.add(new OrderSpecifier(direction, orderByExpression.get(prop)));
        });
        return orders;
    }

    private Expression<?>[] setSearchColumns(Expression<?>... expressions) {
        return expressions.length == 0 ? new Expression[] {
                  codeEntity.grpCd
                , codeEntity.cd
                , codeEntity.pcd
                , codeEntity.level
                , codeEntity.name
                , codeEntity.dscr
                , codeEntity.useAble
                , codeEntity.orderNo
                , codeEntity.strDe
                , codeEntity.endDe
                , codeEntity.registerNo
                , codeEntity.modifierNo
                , codeEntity.mappingCd
                , codeEntity.mappingName
                , codeEntity.userDef1
                , codeEntity.userDef2
                , codeEntity.userDef3
        } : expressions;
    }
}
