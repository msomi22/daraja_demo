package com.peter.demo.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.peter.demo.entity.TokenEntity;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, Long>{ 

}
