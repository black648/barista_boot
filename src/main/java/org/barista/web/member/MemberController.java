package org.barista.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
@Log4j2
public class MemberController {

//    private final PasswordEncoder passwordEncoder;
//    private final TokenProvider jwtTokenProvider;
//
//    // 회원가입
//    @RequestMapping(value = "/join", method = RequestMethod.POST)
//    public Long join(@RequestBody MemberEntity member) {
//        return ServiceUtil.getMemberService().create(member);
//    }
//
//    // 로그인
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestBody Map<String, String> user) {
//        MemberEntity member = ServiceUtil.getMemberService().get(user.get("mberId"));
//
//        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
//            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
//        }
//        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
//    }
    // https://webfirewood.tistory.com/115 여기 참고해서 테스트해보자
}
