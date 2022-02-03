package org.barista.service.common.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class SearchCommonDto {

    private String registerDeTo;
    private String registerDeFrom;

    private String page;
    private String pageSize;

    private Sort sort;
}
