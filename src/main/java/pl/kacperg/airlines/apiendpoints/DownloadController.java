package pl.kacperg.airlines.apiendpoints;

import org.springframework.web.bind.annotation.*;
import pl.kacperg.airlines.user.User;
import pl.kacperg.airlines.user.UserRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@RestController
public class DownloadController {
    private final UserRepository userRepository;

    public DownloadController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/user/{userId}/download")
    @ResponseBody
    public Certificate downloadFile(@PathVariable Long userId) throws IOException {
        User user = userRepository.getById(userId);
//        File file = new File(user.getCovidCertificate());
//        StringBuilder stringBuilder = new StringBuilder();
//        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
//        lines.forEach(stringBuilder::append);
//        Certificate certificate = new Certificate();
//        certificate.setUserPersonals(user.toString());
//        certificate.setUserCovidCertificate(stringBuilder.toString());
        return null;
    }
}
