package org.barista.framework.base;

import com.querydsl.core.types.Expression;
import org.barista.service.attach.entity.QAttachEntity;
import org.barista.service.board.entity.QBoardEntity;
import org.barista.service.common.entity.QCodeEntity;
import org.barista.service.member.entity.QMemberEntity;

import java.util.List;
import java.util.Map;

public interface BaseRepository<Dto extends BaseDto> {

    QBoardEntity Q_BOARD_ENTITY = QBoardEntity.boardEntity;
    QMemberEntity Q_MEMBER_ENTITY = QMemberEntity.memberEntity;
    QCodeEntity Q_CODE_ENTITY = QCodeEntity.codeEntity;

    QAttachEntity Q_ATTACH_ENTITY = QAttachEntity.attachEntity;

    Dto get(String id, Expression<?>... expressions);
    Map<String, Object> getList(Object obj, Expression<?>... expressions);

    List<Dto> getOnlyList(Object obj, Expression<?>... expressions);
}
