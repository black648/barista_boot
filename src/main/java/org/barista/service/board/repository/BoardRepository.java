package org.barista.service.board.repository;

import org.barista.service.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, String>, BoardRepositoryCustom {
}
