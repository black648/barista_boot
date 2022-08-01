package org.barista.framework.base;

import com.querydsl.core.types.Expression;

import java.util.List;
import java.util.Map;

public interface BaseService<Dto extends BaseDto> {
//    Dto get(String UID);

    Dto get(String UID, Expression<?>... expressions);
    Map<String, Object> getList(Object obj, Expression<?>... expressions);

    List<Dto> getOnlyList(Object obj, Expression<?>... expressions);

//    Dto update(Dto vo, Expression<?>... expressions);

}
