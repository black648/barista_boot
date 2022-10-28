package org.barista.framework.utils;

import org.barista.framework.component.PropertyComponent;
import org.barista.service.attach.dto.AttachDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Calendar;

public class FileUtil {

    public static String getUploadPath(String fileExt) throws Exception {
        try {
            Calendar currentTime = Calendar.getInstance();
            String fileDirPath = PropertyComponent.fileUploadPath + getDir(currentTime);

            File dir = new File(fileDirPath);
            if (!dir.isDirectory()) {
                dir.mkdirs();
            }
            return fileDirPath + File.separator + currentTime.getTimeInMillis() + "." + fileExt;
        } catch (Exception e) {
            throw new Exception("파일경로 생성에 오류가 발생하였습니다.");
        }
    }

    public static String getDir(Calendar currentTime){
        return currentTime.get(Calendar.YEAR) + File.separator
                + (currentTime.get(Calendar.MONTH) + 1) + File.separator
                + currentTime.get(Calendar.DAY_OF_MONTH) + File.separator
                + currentTime.get(Calendar.HOUR_OF_DAY);
    }

    //multipart 데이터로 attach 테이블 등록을 위한 데이터 세팅
    public static AttachDto setAttachDto(MultipartFile multipartFile) throws Exception {

        AttachDto attachDto = new AttachDto();
        attachDto.setId(Utils.getID());
        attachDto.setOrgFileName(multipartFile.getOriginalFilename());
        attachDto.setSavedFileName(Utils.getID());
        attachDto.setFileSize(String.valueOf(multipartFile.getSize()));
        attachDto.setFileExt(getFileExt(attachDto.getOrgFileName()));
        attachDto.setDivision(Utils.getID());
        attachDto.setDivisionId(Utils.getID());
        attachDto.setRealDirPath(getUploadPath(attachDto.getFileExt()));
        attachDto.setDirPath(getFileName(attachDto.getRealDirPath()));

        return attachDto;
    }


    public static String getFileExt(String fileName) throws Exception {
        if (ObjectUtil.isEmpty(fileName)) {
            throw new Exception("파라미터가 전달되지 않았습니다.");
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public static String getFileName(String filePath) throws Exception {
        if (ObjectUtil.isEmpty(filePath)) {
            throw new Exception("파라미터가 전달되지 않았습니다.");
        }
        return filePath.substring(filePath.lastIndexOf("/") + 1);
    }

}
