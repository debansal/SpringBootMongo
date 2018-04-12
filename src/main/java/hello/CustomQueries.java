package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomQueries {

    @Autowired
    MongoTemplate mongoTemplate;
/*
    public List<Customer>  runQuery(){
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").regex("^A"));
        List<Customer> customers = mongoTemplate.find(query,Customer.class);
        return customers;
    }*/
}
