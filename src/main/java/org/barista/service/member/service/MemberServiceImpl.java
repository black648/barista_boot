package org.barista.service.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.barista.config.security.TokenProvider;
import org.barista.framework.utils.Utils;
import org.barista.service.member.dto.MemberDto;
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
    private final TokenProvider jwtTokenProvider;

    @Override
    public String create (MemberEntity member) {
        return memberRepository.save(MemberEntity.builder()
                .mberNo(Utils.getID())
                .mberId(member.getMberId())
                .email(member.getEmail())
                .mberName(member.getMberName())
                .password(passwordEncoder.encode(member.getPassword()))
                .mberSe("ROLE_USER").build()).getMberId();

        // 최초 가입시 USER 로 설정

    }

    @Override
    public MemberEntity getEntity(String mberId) throws UsernameNotFoundException {
        return memberRepository.get(mberId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

    @Override
    public MemberDto get(String mberId) throws UsernameNotFoundException {
        return setDtoToEntity(getEntity(mberId));
    }

    @Override
    public MemberDto doLogin(String mberId, String password) throws UsernameNotFoundException {
        MemberEntity memberEntity  = getEntity(mberId);

        if (!passwordEncoder.matches(password, memberEntity.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return setDtoToEntity(memberEntity);
    }

    protected MemberDto setDtoToEntity (MemberEntity entity) {
        return MemberDto.getMemberDto(entity, jwtTokenProvider.createToken(entity));
    }

}
