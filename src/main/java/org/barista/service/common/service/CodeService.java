package org.barista.service.common.service;


import com.querydsl.core.types.Expression;
import org.barista.framework.base.BaseService;
import org.barista.service.common.dto.CodeDto;
import org.barista.service.common.dto.CodeSearchDto;

import java.util.List;

public interface CodeService extends BaseService<CodeDto> {
    List<CodeDto> getCodeList(CodeSearchDto searchDto);
}
