package com.ust.IntegrationApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@Configuration
//@PropertySource("classpath:mongodb.properties")
// @ComponentScan(basePackages = {"com.ust.social.persistence.*"})
//@EnableMongoRepositories(basePackages = { "com.ust.social.persistence.*" })

@EnableMongoRepositories(basePackages = { "com.ust.vo.*" })

public class MongoDBConfig {
	
    @Autowired
    private Environment env;
    
    
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
                   String host = "localhost";//env.getProperty("db.host");
                   int port = 27017;
                   String dbName = "INTEGRATION";
                   MongoClientOptions.Builder options = MongoClientOptions.builder();
                   options.socketKeepAlive(true);
    options.socketTimeout(60000);//Integer.parseInt(env.getProperty("db.socket_timeout"))
    options.connectTimeout(60000);//Integer.parseInt(env.getProperty("db.connect_timeout"))
    options.connectionsPerHost(15);//Integer.parseInt(env.getProperty("db.connections_per_host"))
   // options.minConnectionsPerHost(Integer.parseInt(env.getProperty("db.min_connections_per_host")));
    //options.maxConnectionIdleTime(Integer.parseInt(env.getProperty("db.maxIdleTimeMS")));
    //options.maxConnectionLifeTime(Integer.parseInt(env.getProperty("db.maxconnLifeTimeMS")));
                   // options.r
                  // Logger.getLogger("org.mongodb").setLevel(Level.ERROR);
                   return new SimpleMongoDbFactory(new MongoClient(new ServerAddress(host, port), options.build()), dbName);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
                   MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
                   return mongoTemplate;
    }



}
