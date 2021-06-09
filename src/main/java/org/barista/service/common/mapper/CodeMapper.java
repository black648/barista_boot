package org.barista.service.common.mapper;

import org.barista.service.common.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CodeMapper extends JpaRepository<CodeEntity, String>, CodeMapperCustom{

}
