package org.barista.service.common.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.barista.framework.base.BaseRepository;
import org.barista.framework.base.BaseServiceImpl;
import org.barista.framework.base.BaseSpecs;
import org.barista.framework.constants.ColumnConstants;
import org.barista.framework.utils.ObjectUtil;
import org.barista.service.common.dto.CodeDto;
import org.barista.service.common.dto.CodeSearchDto;
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
public class CodeServiceImpl extends BaseServiceImpl<CodeDto> implements CodeService{

    private final CodeRepository codeRepository;

    @Override
    public BaseRepository getRepository() {
        return codeRepository;
    }

    @Override
    public List<CodeDto> getCodeList(CodeSearchDto searchDto) {

        searchDto.setSort(Sort.by(Sort.Order.asc(ColumnConstants.LEVEL)
                , Sort.Order.asc(ColumnConstants.ORDER_NO)));

        List<CodeDto> list = codeRepository.getList(searchDto);
        list.stream().forEach(code -> {
            searchDto.setPcd(code.getCd());
            searchDto.setLevel(3);
            code.setCodeList(codeRepository.getList(searchDto));
        });

        return list;
    }

    private static Map<String, Object> paramSet (Map<String, Object> paramMap) {
        if (ObjectUtil.isEmpty(paramMap)) {
            paramMap = new HashMap<>();
        }
        paramMap.put(ColumnConstants.USE_ABLE, "T");

        return paramMap;
    }

    public static Specification<CodeEntity> codeSpecification(Map<String, Object> searchKeyword) {
        return (Specification<CodeEntity>) ((root, query, builder) -> {
            query.orderBy(builder.asc(root.get("level")), builder.asc(root.get("orderNo")));
            List<Predicate> predicate = BaseSpecs.getPredicateWithKeyword(searchKeyword, root, builder);

            return builder.and(predicate.toArray(new Predicate[0]));
        });
    }

}
