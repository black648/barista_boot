package org.barista.service.common.service;


import org.barista.service.common.entity.CodeEntity;
import org.barista.service.common.vo.CodeVO;

import java.util.List;

public interface CodeService {
    List<CodeEntity> getCodeList(String grpCd);
}
