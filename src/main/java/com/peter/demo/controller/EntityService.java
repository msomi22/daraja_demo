/**
 * 
 */
package com.peter.demo.controller;

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
        return (List<TokenEntity>) tokenRepository.findAll();
    }

    public Optional<TokenEntity> findById(Long id) {
        return tokenRepository.findById(id);
    }

    public TokenEntity save(TokenEntity token) {
        return tokenRepository.save(token);
    }

}
