package at.refugeescode.MongoDBAndFImages.controller;

import at.refugeescode.MongoDBAndFImages.logic.ImageHandler;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageHandler imageHandler;

    @GetMapping
    String page() {
        return "image";
    }

    @ModelAttribute("imageId")
    ObjectId imageId() {
        return imageHandler.getObjectId();
    }

}
