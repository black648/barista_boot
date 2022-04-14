package org.barista.service.common.repository;


import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
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
        return queryFactory.select(Projections.fields(CodeDto.class, expressions))
                .from(codeEntity)
                .where( cdEq((String) id), useableEq())
                .fetchOne();
    }

    @Override
    public List<CodeDto> getList(Object obj, Expression<?>... expressions) {
        CodeSearchDto searchDto = (CodeSearchDto) obj;

        return queryFactory.select(Projections.fields(CodeDto.class, expressions))
                .from(codeEntity)
                .where(
                        grpCdEq(searchDto.getGrpCd()),
                        cdEq(searchDto.getCd()),
                        pcdEq(searchDto.getPcd()),
                        levelEq(searchDto.getLevel()),
                        useableEq()
                )
                .orderBy(getOrderSpecifier(searchDto.getSort()).stream().toArray(OrderSpecifier[]::new))
                .fetch();
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

    private Expression<?>[] setAllSearchColumn() {
        return new Expression[] {
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
        };
    }
}
