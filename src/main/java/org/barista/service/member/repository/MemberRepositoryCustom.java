package org.barista.service.member.repository;

import org.barista.service.member.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<MemberEntity> get(String mberid);
}
