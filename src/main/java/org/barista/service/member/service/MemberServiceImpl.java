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
    public String create (MemberEntity member) {

        return memberRepository.save(MemberEntity.builder()
                .mberNo(Utils.getID())
                .mberId(member.getMberId())
                .password(passwordEncoder.encode(member.getPassword()))
                .mberSe("ROLE_USER").build()).getMberId();

        // 최초 가입시 USER 로 설정

    }

    @Override
    public MemberEntity get(String mberId) throws UsernameNotFoundException {
        return memberRepository.get(mberId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
}
