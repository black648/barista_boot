package org.barista.service.member.service;

import org.barista.service.member.entity.MemberEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MemberService {
    long create(MemberEntity member);

    MemberEntity get(String mberid) throws UsernameNotFoundException;
}
