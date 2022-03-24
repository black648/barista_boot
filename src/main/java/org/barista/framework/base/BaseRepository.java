package org.barista.framework.base;

import com.querydsl.core.types.Expression;

import java.util.List;

public interface BaseRepository<Dto extends BaseDto> {

    Dto get(String id);
    Dto get(String id, Expression<?>... expressions);
    List<Dto> getList(Object obj);
    List<Dto> getList(Object obj, Expression<?>... expressions);
}
