package at.refugeescode.MongoDBAndFImages.configuration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String mongoAddress;

    @Value("${spring.data.mongodb.database}")
    private String mongoDatabase;

    @Bean
    public GridFSBucket gridFSBucket(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase(mongoDatabase);
        return GridFSBuckets.create(database);
    }

}
