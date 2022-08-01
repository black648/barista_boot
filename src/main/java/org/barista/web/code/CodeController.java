package org.barista.web.code;

import lombok.extern.log4j.Log4j2;
import org.barista.framework.constants.CommonConstants;
import org.barista.framework.utils.APIResult;
import org.barista.framework.utils.APIResultUtil;
import org.barista.framework.utils.ServiceUtil;
import org.barista.service.common.dto.CodeDto;
import org.barista.service.common.dto.CodeSearchDto;
import org.barista.service.common.entity.CodeEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common")
@Log4j2
public class CodeController {

    @RequestMapping(value = "/topMenu", method = RequestMethod.POST)
    public APIResult getTopMenu() {

        CodeSearchDto searchDto = new CodeSearchDto();
        searchDto.setGrpCd("GR002");
        searchDto.setLevel(2);
        searchDto.setUseAble("T");

        return APIResultUtil.getAPIResult(Map.of(CommonConstants.CONST_LIST, ServiceUtil.getCodeService().getCodeList(searchDto)));
    }
}
