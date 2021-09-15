package org.barista.web.code;

import lombok.extern.log4j.Log4j2;
import org.barista.framework.utils.APIResult;
import org.barista.framework.utils.APIResultUtil;
import org.barista.framework.utils.ServiceUtil;
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

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("grpCd","GR002");
        paramMap.put("level",2);
        paramMap.put("useAble","T");
        List<CodeEntity> list = ServiceUtil.getCodeService().getCodeList(paramMap);

        HashMap<String, Object> responseKeyValue = new HashMap<>();
        responseKeyValue.put("list", list);
        return APIResultUtil.getAPIResult(responseKeyValue);
    }
}
