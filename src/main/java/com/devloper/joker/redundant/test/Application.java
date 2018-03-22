package com.devloper.joker.redundant.test;

import com.devloper.joker.redundant.config.RedundantProperties;
import com.devloper.joker.redundant.mongo.MongoRdtOperation;
import com.devloper.joker.redundant.mongo.MongoRdtOperation2;
import com.devloper.joker.redundant.support.RdtResolver;
import com.devloper.joker.redundant.support.RendundantSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import javax.annotation.Resource;
import java.lang.reflect.Field;

@SpringBootApplication
public class Application {

	/*private final static Logger logger = LoggerFactory.getLogger(Application.class);

	@Resource
	private MongoTemplate mongoTemplate;

	@Bean
	@ConfigurationProperties(prefix = "rdt")
	public RedundantProperties redundantProperties() {
		return new RedundantProperties();
	}

	@Bean
	public RendundantSupport rendundantSupport() {
		return redundantProperties().createSupport(rdtResolver());
	}

	@Bean
	public RdtResolver rdtResolver() {
		return new RdtResolver() {
			@Override
			public Class<?>[] baseEntityAnnotations() {
				Class<?>[] classes = new Class[]{Document.class};
				return classes;
			}

			@Override
			public boolean isBaseEntity(Class<?> entityClass) {
				logger.info(entityClass.getName() + " to judge is base entity");
				return false;
			}

			@Override
			public String getColumnName(Class<?> entityClass, Field field) {
				logger.info(entityClass.getName() + " property {} to get column name", field.getName());
				return null;
			}

			@Override
			public String getEntityName(Class<?> entityClass) {
				return null;
			}
		};
	}

	@Bean
	public MongoRdtOperation mongoRdtOperation() {
		MongoRdtOperation operation = new MongoRdtOperation();
		operation.setRendundantSupport(rendundantSupport());
		operation.setMongoTemplate(mongoTemplate);
		return operation;
	}*/


	/*@Bean
	public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context, BeanFactory beanFactory) {
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
		MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
		try {
			mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
		} catch (NoSuchBeanDefinitionException ignore) {
		}

		// Don't save _class to mongo
		mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));

		return mappingConverter;
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
