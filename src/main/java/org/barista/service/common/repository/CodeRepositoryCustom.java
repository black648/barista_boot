package org.barista.service.common.repository;

import com.querydsl.core.types.Expression;
import org.barista.framework.base.BaseRepository;
import org.barista.service.common.dto.CodeDto;
import org.barista.service.common.entity.CodeEntity;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface CodeRepositoryCustom extends BaseRepository<CodeDto> {
    List<CodeEntity> getAll(Map<String, Object> paramMap, Sort sort);
}
