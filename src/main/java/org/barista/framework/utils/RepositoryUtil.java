package org.barista.framework.utils;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.*;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositoryUtil {

    public static BooleanExpression equals(String str, StringPath path) {
        return str != null ? path.eq(str) : null;
    }

    public static BooleanExpression equalsNumber(int num, NumberPath path) {
        return num != 0 ? path.eq(num) : null;
    }

    public static BooleanExpression like(String str, StringPath path) {
        return str != null ? path.like(str) : null;
    }

    public static BooleanExpression before(String str, DateTimePath<LocalDateTime> path) {
        return str != null ? path.before(LocalDateTime.parse(str)) : null;
    }

    public static BooleanExpression after(String str, DateTimePath<LocalDateTime> path) {
        return str != null ? path.after(LocalDateTime.parse(str)) : null;
    }




    public static List<OrderSpecifier> getOrderSpecifier(Sort sort, PathBuilder pathBuilder) {
        List<OrderSpecifier> orders = new ArrayList<>();
        // Sort
        sort.stream().forEach(order -> {
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            String prop = order.getProperty();
            orders.add(new OrderSpecifier(direction, pathBuilder.get(prop)));
        });
        return orders;
    }

    public static int setPage(String page) {
        return page != null ? Integer.parseInt(page) : 0;
    }

    public static int setPageSize(String pageSize) {
        return pageSize != null ? Integer.parseInt(pageSize) : 20;
    }


}
