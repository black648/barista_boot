package org.barista.web.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.barista.framework.utils.APIResultUtil;
import org.barista.framework.utils.ServiceUtil;
import org.barista.service.member.dto.MemberDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
@Log4j2
public class MemberController {

    @RequestMapping(value = "/getMember", method = RequestMethod.POST)
    public Object join(@RequestBody Map<String, String> paramMap) {
        MemberDto member = ServiceUtil.getMemberService().get(paramMap.get("mberId"));

        return APIResultUtil.getAPIResult(member);
    }
    // https://webfirewood.tistory.com/115 여기 참고해서 테스트해보자
}
