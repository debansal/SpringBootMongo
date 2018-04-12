package hello;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

    //@Autowired
    //private CustomerRepository repository;
	//SpringBootMongo.v_0.1

    @Autowired
    MongoTemplate mongoTemplate;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       // ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
       // MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");

        MongoCollection<Document> collection = mongoTemplate.getCollection("website");
        AggregateIterable<Document> output = collection.aggregate(Arrays.asList(
                new Document("$group", new Document("_id", "$hosting").append("count", new Document("$sum", 1)))
        ));
        for (Document doc : output) {
            System.out.println("_id = "  + doc.get("_id") +", count = "+ doc.get("count"));
        }
    }

}