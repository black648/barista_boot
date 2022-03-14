package org.barista.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.barista.config.security.TokenProvider;
import org.barista.framework.constants.CommonConstants;
import org.barista.framework.utils.APIResult;
import org.barista.framework.utils.APIResultUtil;
import org.barista.framework.utils.ObjectUtil;
import org.barista.framework.utils.ServiceUtil;
import org.barista.service.member.dto.MemberDto;
import org.barista.service.member.entity.MemberEntity;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
@Log4j2
public class LoginController {

    private final StringRedisTemplate redisTemplate;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider jwtTokenProvider;

    // 회원가입
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(@RequestBody MemberEntity member) {
        return ServiceUtil.getMemberService().create(member);
    }

    // 로그인
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public APIResult login(@RequestBody Map<String, String> user) {
        MemberDto member = ServiceUtil.getMemberService().doLogin(user.get("mberId"), user.get("password"));

        HashMap<String, Object> responseKeyValue = new HashMap<>();
        responseKeyValue.put("member", member);
        return APIResultUtil.getAPIResult(responseKeyValue);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Object logout(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(token, CommonConstants.CONST_LOGOUT); // redis set 명령어
        MemberEntity member = (MemberEntity) jwtTokenProvider.getAuthentication(token).getPrincipal();
        log.info("로그아웃 유저 아이디 : '{}' , 유저 이름 : '{}'", member.getMberId());

        return APIResultUtil.getAPIResult("로그아웃 되었습니다.");
    }

    @RequestMapping(value = "/checkId", method = RequestMethod.POST)
    public Object checkId(@RequestBody Map<String, String> user) {

        boolean isMember;
        try {
            isMember = ObjectUtil.isNotEmpty(ServiceUtil.getMemberService().get(user.get("mberId"))) ? true : false;
        } catch (Exception e) {
            isMember = false;
        }

        return APIResultUtil.getAPIResult(isMember);
    }
}
