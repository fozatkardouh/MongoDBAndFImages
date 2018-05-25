package at.refugeescode.MongoDBAndFImages.endpoint;

import at.refugeescode.MongoDBAndFImages.logic.ImageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageHandlerEndpoint {

    private final ImageHandler imageHandler;

    @ResponseBody
    @GetMapping("/{id}")
    public byte[] getImage(@PathVariable String id) {
        return imageHandler.load(id);
    }

}
