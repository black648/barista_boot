package org.barista.service.common.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SearchCommonDto {

    private String id;
    private String instanceId;
    private String content;
    private String title;
    private String registerDeTo;
    private String registerDeFrom;
    private String isPublic;
    private String isNotice;
    private String delYn;
    private String page;
    private String pageSize;

    private Sort sort;
}
