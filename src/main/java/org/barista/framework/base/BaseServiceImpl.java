package org.barista.framework.base;

import com.querydsl.core.types.Expression;

import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<Dto extends BaseDto> implements BaseService<Dto> {

    public abstract BaseRepository getRepository();

    public Dto get(String id, Expression<?>... expressions) {
        return (Dto)getRepository().get(id, expressions);
    };
    public Map<String, Object> getList(Object obj, Expression<?>... expressions) {
        return getRepository().getList(obj, expressions);
    }

    public List<Dto> getOnlyList(Object obj, Expression<?>... expressions) {
        return getRepository().getOnlyList(obj, expressions);
    }

//    public Dto update(Dto vo, Expression<?>... expressions) {
//        return getRepository().
//    }
}
