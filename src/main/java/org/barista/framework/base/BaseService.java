package org.barista.framework.base;

import com.querydsl.core.types.Expression;

import java.util.List;

public interface BaseService<Dto extends BaseDto> {
//    Dto get(String UID);

    Dto get(String UID, Expression<?>... expressions);
    List<Dto> getList(Object obj, Expression<?>... expressions);

    long getListCount(Object obj, Expression<?>... expressions);

//    Dto update(Dto vo, Expression<?>... expressions);

}
