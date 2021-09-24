package org.barista.service.member.repository;

import org.barista.service.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String>, MemberRepositoryCustom {
}
