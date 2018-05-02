/**
 * 
 */
package com.turkmen.mongodb.MongoDbIntegrationWithSpringBoot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

/**
 * @author TTTDEMIRCI
 *
 */

@Configuration
public class MongoDbConfiguration {
	
	@Value("${mongo.db.url}")
	private String mongoUrl;
	
	@Value("${mongo.db.name}")
	private String mongoDbName;

	public MongoTemplate getMongoTemplate() throws Throwable {
		EmbeddedMongoFactoryBean mongoFactoryBean = new EmbeddedMongoFactoryBean();
		mongoFactoryBean.setBindIp(mongoUrl);
		MongoClient mongoClient = mongoFactoryBean.getObject();
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, mongoDbName);
		return mongoTemplate;
	}

}
