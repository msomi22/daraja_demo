/**
 * 
 */
package com.peter.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.demo.entity.TokenEntity;
import com.peter.demo.persistence.TokenRepository;

/**
 * @author t_pnjeru
 *
 */

@Service
public class EntityService {
	
	@Autowired
	private TokenRepository tokenRepository;

	public List<TokenEntity> findAll() { 
		Iterable<TokenEntity> list = tokenRepository.findAll();
		long size = list.spliterator().getExactSizeIfKnown();
		System.out.println("------------> " + size );
		
		Iterator<TokenEntity> iter = list.iterator();
		
		List<TokenEntity> tokenList = new ArrayList<TokenEntity>();
		while(iter.hasNext()){
			tokenList.add(iter.next());
		}
		System.out.println("tokenList=" + tokenList);
        return tokenList;
    }

    public Optional<TokenEntity> findById(Long id) {
        return tokenRepository.findById(id);
    }

    public TokenEntity save(TokenEntity token) {
        return tokenRepository.save(token);
    }

}
