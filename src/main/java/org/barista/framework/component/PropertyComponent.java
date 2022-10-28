package org.barista.framework.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("propertyComponent")
public class PropertyComponent {
    public static String fileUploadPath = "";

    @Value("${file.upload.path}")
    private String privateFileUploadPath;

    @PostConstruct
    public void init() {
        fileUploadPath = privateFileUploadPath;
    }
}
