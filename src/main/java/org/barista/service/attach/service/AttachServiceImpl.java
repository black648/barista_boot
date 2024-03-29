package org.barista.service.attach.service;

import com.querydsl.core.types.Expression;
import lombok.RequiredArgsConstructor;
import org.barista.framework.base.BaseRepository;
import org.barista.framework.base.BaseServiceImpl;
import org.barista.framework.constants.ColumnConstants;
import org.barista.framework.utils.FileUtil;
import org.barista.framework.utils.ObjectUtil;
import org.barista.service.attach.dto.AttachDto;
import org.barista.service.attach.dto.AttachSearchDto;
import org.barista.service.attach.repository.AttachRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttachServiceImpl extends BaseServiceImpl<AttachDto> implements AttachService {
    private final AttachRepository attachRepository;
    @Override
    public BaseRepository getRepository() {
        return attachRepository;
    }

    @Override
    public void save(AttachDto attachDto) {
        attachRepository.save(attachDto.toAttachEntity());
    }

    @Override
    public AttachDto getFile(AttachSearchDto searchDto, Expression<?>... expressions) throws Exception {
        if (ObjectUtil.isEmpty(searchDto.getDivision())
                || ObjectUtil.isEmpty(searchDto.getDivisionId())) {
            throw new Exception("첨부파일에 대한 요청정보가 없습니다.");
        }
        return attachRepository.getFile(searchDto, expressions);
    }

    @Override
    public AttachDto fileUpload(MultipartFile multipartFile) throws Exception {
        AttachDto attachDto = null;
        System.out.println(multipartFile.getSize());
        if (!multipartFile.isEmpty()) {
            attachDto = FileUtil.setAttachDto(multipartFile);
            try {
                FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(attachDto.getRealDirPath()));
                attachRepository.save(attachDto.toAttachEntity());
            } catch (Exception e) {
                throw new Exception("업로드에 실패하였습니다.");
            }
        }
        return attachDto;
    }

    public void fileDownload(AttachSearchDto searchDto) {
        searchDto.setOrder(1);
        searchDto.setOrderProperty(ColumnConstants.REGIST_DE);

        List<AttachDto> attachList = getJustList(searchDto);
        System.out.println("aksdfhaklsdhj");
//        try{
//            if (storageList.size() > 1) {
//                2개 이상의 경우 zip
//                UpDownComponent.zipFileDownLoad(storageList);
//            } else {
//                1개의 경우 단일파일
//                UpDownComponent.singleFileDownLoad(storageList.get(0));
//            }
//        }catch (Exception e){
//             다운로드 실패용.!!!
//            e.printStackTrace();
//        }
    }




}
