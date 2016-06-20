package com.ideaincubator.sprinkler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ideaincubator.sprinkler.repository.SensorModuleRepository;
import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories(basePackageClasses = SensorModuleRepository.class)
public class ApplicationConfig  {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        String openshiftMongoDbHost = "localhost";
        Mongo mongo = new Mongo(openshiftMongoDbHost);
      //  UserCredentials userCredentials = new UserCredentials(username, password);
        String databaseName = "sprinklerDB";
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName);
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }
    
}
