package org.barista.framework.base;

import lombok.Data;
import org.springframework.data.domain.Sort;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BaseSearchDto {
    private String searchType;
    private String searchText;

    private String registerDeTo;
    private String registerDeFrom;

    private String page;
    private String pageSize;

    private Sort sort;
}

