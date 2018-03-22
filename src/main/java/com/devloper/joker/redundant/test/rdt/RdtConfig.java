package com.devloper.joker.redundant.test.rdt;

import com.devloper.joker.redundant.config.RedundantProperties;
import com.devloper.joker.redundant.mongo.MongoRdtOperation;
import com.devloper.joker.redundant.support.RdtResolver;
import com.devloper.joker.redundant.support.RendundantSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Resource;
import java.lang.reflect.Field;

@Configuration
public class  RdtConfig {
    @Resource
    private MongoTemplate mongoTemplate;

    @Value("${rdt.domain.basePackage}")
    private String basePackage;

    @Bean
    public RedundantProperties redundantProperties() {
        RedundantProperties properties = new RedundantProperties();
        properties.setBasePackage(basePackage);
        return properties;
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
                return  new Class[] {Document.class};
            }

            @Override
            public boolean isBaseEntity(Class<?> entityClass) {
                return false;
            }

            @Override
            public String getColumnName(Class<?> entityClass, Field field) {
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
    }
}
