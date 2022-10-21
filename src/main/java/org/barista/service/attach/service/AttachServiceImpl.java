package org.barista.service.attach.service;

import lombok.RequiredArgsConstructor;
import org.barista.framework.base.BaseRepository;
import org.barista.framework.base.BaseServiceImpl;
import org.barista.service.attach.dto.AttachDto;
import org.barista.service.attach.repository.AttachRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttachServiceImpl extends BaseServiceImpl<AttachDto> implements AttachService {
    private final AttachRepository attachRepository;

    @Override
    public BaseRepository getRepository() {
        return attachRepository;
    }
}
