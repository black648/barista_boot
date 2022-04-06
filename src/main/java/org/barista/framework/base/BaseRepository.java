package org.barista.framework.base;

import com.querydsl.core.types.Expression;
import org.barista.service.board.entity.QBoardEntity;
import org.barista.service.member.entity.QMemberEntity;

import java.util.List;

public interface BaseRepository<Dto extends BaseDto> {

    QBoardEntity Q_BOARD_ENTITY = QBoardEntity.boardEntity;
    QMemberEntity Q_MEMBER_ENTITY = QMemberEntity.memberEntity;

    Dto get(String id);
    Dto get(String id, Expression<?>... expressions);
    List<Dto> getList(Object obj);
    List<Dto> getList(Object obj, Expression<?>... expressions);
}
