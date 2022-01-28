package org.barista.web.board;

import lombok.extern.log4j.Log4j2;
import org.barista.framework.utils.APIResult;
import org.barista.framework.utils.APIResultUtil;
import org.barista.framework.utils.ServiceUtil;
import org.barista.service.board.entity.BoardEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
@Log4j2
public class BoardController {

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public APIResult getTopMenu(@RequestBody Map<String, Object> paramMap) {

        List<BoardEntity> list = ServiceUtil.getBoardService().getList(paramMap);

        HashMap<String, Object> responseKeyValue = new HashMap<>();
        responseKeyValue.put("list", list);

        return APIResultUtil.getAPIResult(responseKeyValue);
    }
}