/**
 * 
 */
package com.turkmen.mongodb.MongoDbIntegrationWithSpringBoot.configuration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;


/**
 * @author TTTDEMIRCI
 *
 */

@Configuration
public class MongoDbConfiguration {
	
	private static final Logger logger=LoggerFactory.getLogger(MongoDbConfiguration.class);
	
	@Value("${spring.data.mongodb.host}")
	private String mongoUrl;
	
	@Value("${spring.data.mongodb.database}")
	private String mongoDbName;
	
	@Value("${spring.data.mongodb.port}")
	private int mongoPort;
	
	MongodStarter starter = MongodStarter.getDefaultInstance();
	MongodExecutable mongodExecutable;
	
	@Bean
	public MongoTemplate mongoTemplate() throws IOException {
		
		logger.info("Starting embeded mongo db.................................");
		EmbeddedMongoFactoryBean mongoFactoryBean = new EmbeddedMongoFactoryBean();
		mongoFactoryBean.setBindIp(mongoUrl);
		MongoClient mongoClient = mongoFactoryBean.getObject();
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, mongoDbName);
		return mongoTemplate;
	}
	
	
	
}
