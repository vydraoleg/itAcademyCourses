package by.azot.asutp.services.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LogoFileUploader {

    private static final String IMAGE_EXTENSION = ".jpg";
    private static final String LOGOS_FOLDER_PATH = "classpath:static/images/";

    public void updateOrCreateLogo(MultipartFile file, String fileName) throws IOException {
        if (file != null && !file.isEmpty()) {
//            String userName = fileName;
            String filePath = new StringBuilder(LOGOS_FOLDER_PATH).append(fileName).append(IMAGE_EXTENSION)
                    .toString();
            File fileLogo;
            try {
                fileLogo = ResourceUtils.getFile(filePath);
            } catch (FileNotFoundException e) {
                URL fileUrl = ResourceUtils.getURL(LOGOS_FOLDER_PATH);
                fileLogo = new File(
                        new StringBuilder(fileUrl.getPath()).append(fileName).append(IMAGE_EXTENSION).toString());
            }
            Path path = Paths.get(fileLogo.getPath());
            byte[] bytes = file.getBytes();
            Files.write(path, bytes);
        }
    }

    public void updateLogo(MultipartFile file, String fileName) throws IOException {
        if (file != null && !file.isEmpty()) {
            File existingFile = ResourceUtils.getFile(new StringBuilder(LOGOS_FOLDER_PATH).append(fileName)
                    .append(IMAGE_EXTENSION).toString());
            Path path = Paths.get(existingFile.getPath());
            byte[] bytes = file.getBytes();
            Files.write(path, bytes);
        }
    }



}
