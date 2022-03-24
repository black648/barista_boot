package org.barista.framework.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseDto {
    private LocalDateTime registDe;
    private LocalDateTime modifyDe;

}
