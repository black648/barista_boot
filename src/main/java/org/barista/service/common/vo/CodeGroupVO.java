package org.barista.service.common.vo;

import org.barista.service.common.entity.CodeGroupEntity;
import org.springframework.stereotype.Component;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Component
public class CodeGroupVO extends CodeGroupEntity {


@OneToMany(fetch = FetchType.LAZY)
    private List<CodeVO> codeList = new ArrayList<>();
}
