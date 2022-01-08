package pl.kacperg.airlines.upload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    public File uploadFile(MultipartFile multipartFile) {
        File file1;
        try {
             Path copyLocation = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(multipartFile.getOriginalFilename()));
            Files.copy(multipartFile.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            file1 = copyLocation.toFile();
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store multipartFile " + multipartFile.getOriginalFilename()
                    + ". Please try again!");
        }
        return file1;
    }

}
