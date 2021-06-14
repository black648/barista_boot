package org.barista.service.common.repository;


import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.barista.service.common.entity.CodeEntity;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.barista.service.common.entity.QCodeEntity.codeEntity;

@RequiredArgsConstructor
@Repository
public class CodeRepository {
    private final JPAQueryFactory queryFactory;

    public List<CodeEntity> findByGrpcd(Map<String, Object> paramMap, Sort sort) {
        return queryFactory.selectFrom(codeEntity)
                .where(
                        grpcdEq((String) paramMap.get("grpcd")),
                        cdEq((String) paramMap.get("cd")),
                        pcdEq((String) paramMap.get("pcd")),
                        lvlEq((Integer) paramMap.get("lvl")),
                        useableEq()
                )
                .orderBy((OrderSpecifier<?>) getOrderSpecifier(sort))
                .fetch();
    }

    // 조건부
    private BooleanExpression grpcdEq(String grpcd) {
        return grpcd != null ? codeEntity.grpcd.eq(grpcd) : null;
    }

    private BooleanExpression cdEq(String cd) {
        return cd != null ? codeEntity.cd.eq(cd) : null;
    }

    private BooleanExpression pcdEq(String pcd) {
        return pcd != null ? codeEntity.pcd.eq(pcd) : null;
    }

    private BooleanExpression lvlEq(int lvl) {
        return lvl != 0 ? codeEntity.lvl.eq(lvl) : null;
    }

    private BooleanExpression useableEq() {
        return codeEntity.useable.eq("T");
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

}
