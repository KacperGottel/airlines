package pl.kacperg.airlines.apiendpoints;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import pl.kacperg.airlines.user.User;
import pl.kacperg.airlines.user.UserRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@RestController
@Slf4j
public class DownloadController {

    private final UserRepository userRepository;

    public DownloadController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/user/{userId}/show")
    @ResponseBody
    public Certificate showCertificate(@PathVariable Long userId) throws IOException {
        User user = userRepository.getById(userId);
        File file = new File(user.getCovidCertificate());
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        lines.forEach(stringBuilder::append);
        Certificate certificate = new Certificate();
        certificate.setUserPersonals("USER:" + user.getFirstName() + "," + user.getLastName() + "," + user.getEmail());
        certificate.setUserCovidCertificate(stringBuilder.toString());
        return certificate;
    }

    @GetMapping(value = "/user/{userId}/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource getFile(@PathVariable Long userId) throws IOException {
        User user = userRepository.getById(userId);
        File file = new File(user.getCovidCertificate());
        try (FileWriter fileWriter = new FileWriter(file,true)) {
            fileWriter.append("USER:" + user.getFirstName() + "," + user.getLastName() + "," + user.getEmail());
        }
        return new FileSystemResource(file);
    }
}
