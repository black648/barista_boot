package org.barista.service.common.repository;

import org.barista.service.common.entity.CodeEntity;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public interface CodeRepositoryCustom {
    List<CodeEntity> getAll(Map<String, Object> paramMap, Sort sort);
}
