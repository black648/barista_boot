package org.barista.framework.utils;

import org.barista.service.board.entity.QBoardEntity;
import org.barista.service.member.entity.QMemberEntity;
import org.springframework.stereotype.Component;

import static org.barista.service.board.entity.QBoardEntity.boardEntity;
import static org.barista.service.member.entity.QMemberEntity.memberEntity;

@Component
public class QEntityUtil {

    public static QBoardEntity board = boardEntity;
    public static QMemberEntity member = memberEntity;

}
