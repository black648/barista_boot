package org.barista.service.member.service;

import org.barista.service.member.dto.MemberDto;
import org.barista.service.member.entity.MemberEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MemberService {
    String create(MemberEntity member);

    MemberEntity getEntity(String mberId) throws UsernameNotFoundException;

    MemberDto get(String mberId) throws UsernameNotFoundException;

    MemberDto doLogin(String mberId, String password) throws UsernameNotFoundException;
}
