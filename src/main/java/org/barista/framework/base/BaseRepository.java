package org.barista.framework.base;

import com.querydsl.core.types.Expression;
import org.barista.service.board.entity.QBoardEntity;
import org.barista.service.common.entity.QCodeEntity;
import org.barista.service.member.entity.QMemberEntity;

import java.util.List;

public interface BaseRepository<Dto extends BaseDto> {

    QBoardEntity Q_BOARD_ENTITY = QBoardEntity.boardEntity;
    QMemberEntity Q_MEMBER_ENTITY = QMemberEntity.memberEntity;
    QCodeEntity Q_CODE_ENTITY = QCodeEntity.codeEntity;

    Dto get(String id, Expression<?>... expressions);
    List<Dto> getList(Object obj, Expression<?>... expressions);
}
