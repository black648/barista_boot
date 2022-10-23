package org.barista.web.attach;

import lombok.extern.log4j.Log4j2;
import org.barista.framework.utils.APIResult;
import org.barista.framework.utils.APIResultUtil;
import org.barista.framework.utils.ServiceUtil;
import org.barista.service.attach.dto.AttachSearchDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attach")
@Log4j2
public class AttachController {

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public APIResult getList(@RequestBody AttachSearchDto searchDto) {
        return APIResultUtil.getAPIResult(ServiceUtil.getAttachService().getList(searchDto));
    }
}
