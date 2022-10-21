package org.barista.service.attach.repository;

import org.barista.service.attach.entity.AttachEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachRepository extends JpaRepository<AttachEntity, String>, AttachRepositoryCustorm {
}
