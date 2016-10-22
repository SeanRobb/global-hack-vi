package io.ctl.globalhack.config;

import com.ctlts.wfaas.data.orchestrate.config.EnableOrchestrateRepositories;
import com.ctlts.wfaas.data.orchestrate.repository.OrchestrateTemplate;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan
@EnableMongoRepositories("io.ctl.globalhack.repository")
public class GlobalHackConfig {

    public static final String EXCHANGE_MONITOR_DB = "globalHackVIDb";

    @Value("${mongo.database.host:mongo}")
    private String mongoHost;

    @Value("${mongo.database.port:27017}")
    private Integer mongoPort;

    public MongoTemplate mongoTemplate;

//    @PostConstruct
//    public void init() {
//            log.info("---------- Mongo Configuration -----------");
//            log.info("Mongo Host: " + mongoHost);
//            log.info("Mongo Port: " + mongoPort);
//            log.info("Mongo Connected: " + connected);
//            log.info("------------------------------------------");
//    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongoHost, mongoPort), EXCHANGE_MONITOR_DB);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        this.mongoTemplate = mongoTemplate;
        return mongoTemplate;
    }

}
