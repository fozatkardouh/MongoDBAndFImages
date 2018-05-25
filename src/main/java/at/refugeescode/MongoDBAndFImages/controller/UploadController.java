package at.refugeescode.MongoDBAndFImages.controller;

import at.refugeescode.MongoDBAndFImages.logic.ImageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/upload")
@RequiredArgsConstructor
public class UploadController {

    private final ImageHandler imageHandler;

    @GetMapping
    public String page() {
        return "upload";
    }

    @PostMapping
    public String uploadFileHandler(@RequestParam("image") MultipartFile image) throws IOException {
        imageHandler.save(image);
        return "redirect:/image";
    }

}
