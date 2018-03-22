package com.devloper.joker.redundant.test.repository.base;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T> extends MongoRepository<T, String> {

}
