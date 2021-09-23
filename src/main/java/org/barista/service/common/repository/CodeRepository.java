package org.barista.service.common.repository;

import org.barista.service.common.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<CodeEntity, String>, CodeRepositoryCustom {
}
