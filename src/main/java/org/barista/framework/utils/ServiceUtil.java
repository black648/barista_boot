package org.barista.framework.utils;

import org.barista.service.board.service.BoardService;
import org.barista.service.common.service.CodeService;
import org.barista.service.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceUtil {

    protected static BoardService boardService;
    public static BoardService getBoardService() { return boardService; }
    @Autowired
    public void setBoardService(BoardService boardService) { ServiceUtil.boardService = boardService; }

    protected static CodeService codeService;
    public static CodeService getCodeService() {
        return codeService;
    }
    @Autowired
    public void setCodeService(CodeService codeService) {
        ServiceUtil.codeService = codeService;
    }

    protected static MemberService memberService;
    public static MemberService getMemberService() {
        return memberService;
    }
    @Autowired
    public void setMemberService(MemberService memberService) {
        ServiceUtil.memberService = memberService;
    }
}
