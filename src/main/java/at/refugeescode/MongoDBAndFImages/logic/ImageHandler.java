package at.refugeescode.MongoDBAndFImages.logic;

import com.mongodb.client.gridfs.GridFSBucket;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageHandler {

    private final GridFSBucket gridFSBucket;

    @Getter
    private ObjectId objectId;

    public byte[] load(String imageId) {
        ObjectId id = new ObjectId(imageId);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        gridFSBucket.downloadToStream(id, outputStream);
        return outputStream.toByteArray();
    }

    public void save(MultipartFile image) throws IOException {
        objectId = gridFSBucket.uploadFromStream(image.getName(), image.getInputStream());
    }

}
