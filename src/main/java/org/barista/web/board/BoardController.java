package org.barista.web.board;

import lombok.extern.log4j.Log4j2;
import org.barista.framework.constants.CommonConstants;
import org.barista.framework.utils.APIResult;
import org.barista.framework.utils.APIResultUtil;
import org.barista.framework.utils.ServiceUtil;
import org.barista.service.board.dto.BoardSearchDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/board")
@Log4j2
public class BoardController {

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public APIResult getList(@RequestBody BoardSearchDto searchDto) {
        return APIResultUtil.getAPIResult(ServiceUtil.getBoardService().getList(searchDto));
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public APIResult getView(@RequestBody BoardSearchDto searchDto) {

        HashMap<String, Object> responseKeyValue = new HashMap<>();
        responseKeyValue.put("board", ServiceUtil.getBoardService().get(searchDto.getId()));

        return APIResultUtil.getAPIResult(responseKeyValue);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public APIResult update(@RequestBody BoardSearchDto searchDto) {

        ServiceUtil.getBoardService().update();
        System.out.println("aksdjhfkalsdhfkljsadfhkljsdfa");

        return APIResultUtil.getAPIResult();
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public APIResult save(@RequestBody BoardDto dto) {
//
//        ServiceUtil.getBoardService().saveD(dto);
//        System.out.println("aksdjhfkalsdhfkljsadfhklja");
//
//        return APIResultUtil.getAPIResult();
//    }

}
