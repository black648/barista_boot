package org.barista.web.attach;

import lombok.extern.log4j.Log4j2;
import org.barista.framework.constants.ColumnConstants;
import org.barista.framework.constants.CommonConstants;
import org.barista.framework.utils.*;
import org.barista.service.attach.dto.AttachDto;
import org.barista.service.attach.dto.AttachSearchDto;
import org.barista.service.attach.service.AttachService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attach")
@Log4j2
public class AttachController {

    @RequestMapping(value = "/getFile", method = RequestMethod.POST)
    public APIResult getFile(@RequestBody AttachSearchDto searchDto) throws Exception {
        return APIResultUtil.getAPIResult(ServiceUtil.getAttachService().getFile(searchDto));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public APIResult getList(@RequestBody AttachSearchDto searchDto) {
        return APIResultUtil.getAPIResult(ServiceUtil.getAttachService().getList(searchDto));
    }

    @RequestMapping(value = "/upLoad", method = {RequestMethod.GET, RequestMethod.POST})
    public APIResult upLoad(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> fileList = multipartHttpServletRequest.getFiles("file[]");

        List<AttachDto> attachList = new ArrayList<>();

        for(MultipartFile multipartFile : fileList) {
            AttachDto attachDto = ServiceUtil.getAttachService().fileUpload( multipartFile);
            if( ObjectUtil.isNotEmpty(attachDto)) {
                attachList.add(attachDto);
            }
        }
        HashMap<String, Object> responseKeyValue = new HashMap<>();
        responseKeyValue.put("list", attachList);

        return APIResultUtil.getAPIResult(responseKeyValue);
    }

    @RequestMapping(value = "/downLoad", method = {RequestMethod.GET, RequestMethod.POST})
    public APIResult downLoad(@RequestBody Map<String, Object> paramMap) throws Exception {

        String ids = (String) paramMap.get(ColumnConstants.IDS);
        paramMap.put(ColumnConstants.IDS, ids.split(CommonConstants.CONST_COMMA));

        ServiceUtil.getAttachService().fileDownload(ConvertUtil.mapToDTO(paramMap, AttachSearchDto.class));
        return APIResultUtil.getAPIResult();
    }

}
