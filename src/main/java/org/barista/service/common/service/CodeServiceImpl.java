package org.barista.service.common.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.barista.framework.base.BaseSpecs;
import org.barista.framework.utils.ObjectUtil;
import org.barista.service.common.entity.CodeEntity;
import org.barista.service.common.repository.CodeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService{

    private final CodeRepository codeRepository;

    @Override
    public List<CodeEntity> getCodeList(Map<String, Object> paramMap) {
// when
        Sort sort = Sort.by(Sort.Order.asc("lvl"), Sort.Order.asc("orderno"));

        return codeRepository.findByGrpcd(paramMap, sort);
    }

    private static Map<String, Object> paramSet (Map<String, Object> paramMap) {
        if (ObjectUtil.isEmpty(paramMap)) {
            paramMap = new HashMap<>();
        }
        paramMap.put("useable","T");

        return paramMap;
    }

    public static Specification<CodeEntity> codeSpecification(Map<String, Object> searchKeyword) {
        return (Specification<CodeEntity>) ((root, query, builder) -> {
            query.orderBy(builder.asc(root.get("lvl")), builder.asc(root.get("orderno")));
            List<Predicate> predicate = BaseSpecs.getPredicateWithKeyword(searchKeyword, root, builder);

            return builder.and(predicate.toArray(new Predicate[0]));
        });
    }

}
