package org.barista.framework.base;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathInits;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BaseMap<VO extends BaseEntity> extends EntityPathBase<VO> {
    public BaseMap(Class<? extends VO> type, String variable) {
        super(type, variable);
    }

    public BaseMap(Class<? extends VO> type, PathMetadata metadata) {
        super(type, metadata);
    }

    public BaseMap(Class<? extends VO> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
    }

    public Map<Path, Object> setQMap(Map<String, Object> paramMap ) {
        Map<Path, Object> map = new HashMap<>();

        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            if (entry.getValue() instanceof Boolean) {
                map.put(createBoolean(entry.getKey()), entry.getValue());
            } else if (entry.getValue() instanceof LocalDateTime) {
                map.put(createDateTime(entry.getKey(), java.time.LocalDateTime.class), entry.getValue());
            } else {
                map.put(createString(entry.getKey()), entry.getValue());
            }
        }
        return map;
    }
}