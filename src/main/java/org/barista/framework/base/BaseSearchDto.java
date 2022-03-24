package org.barista.framework.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    private int order = 0;
    private String orderProperty;

    @JsonIgnore
    private Sort sort;

    @JsonProperty
    public void setSort(int order, String property) {
        this.sort = order == 0 ? Sort.by(Sort.Order.desc(property)) : Sort.by(Sort.Order.asc(property));
    }

}

