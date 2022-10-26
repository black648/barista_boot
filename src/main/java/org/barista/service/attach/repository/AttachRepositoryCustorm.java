package org.barista.service.attach.repository;

import com.querydsl.core.types.Expression;
import org.barista.framework.base.BaseRepository;
import org.barista.service.attach.dto.AttachDto;
import org.barista.service.attach.dto.AttachSearchDto;

public interface AttachRepositoryCustorm  extends BaseRepository<AttachDto> {
    AttachDto getFile(AttachSearchDto searchDto, Expression<?>... expressions);
}
