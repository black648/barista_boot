package org.barista.service.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.barista.framework.utils.Utils;
import org.barista.service.member.entity.MemberEntity;
import org.barista.service.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public long create (MemberEntity member) {
//        long create = memberRepository.create(member);
        member.setMberId(Utils.getID());
        memberRepository.save(member);

        MemberEntity.builder()
                .mberId(member.getMberId())
                .password(passwordEncoder.encode(member.getPassword()))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build();

        return 1;
    }


    
    @Override
    public MemberEntity get(String mberId) throws UsernameNotFoundException {
        return memberRepository.get(mberId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
}
