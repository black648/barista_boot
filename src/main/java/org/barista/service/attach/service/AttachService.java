package org.barista.service.attach.service;

import com.querydsl.core.types.Expression;
import org.barista.framework.base.BaseService;
import org.barista.service.attach.dto.AttachDto;
import org.barista.service.attach.dto.AttachSearchDto;
import org.springframework.web.multipart.MultipartFile;

public interface AttachService extends BaseService<AttachDto> {
    AttachDto getFile(AttachSearchDto searchDto, Expression<?>... expressions) throws Exception;

    AttachDto fileUpload(MultipartFile multipartFile) throws Exception ;

    void save(AttachDto attachDto);
}
