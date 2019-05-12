/**
 * 
 */
package com.peter.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author t_pnjeru
 *
 */
@Entity
public class TokenEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String token;
	private String expiry;
	
	public TokenEntity() {
		
	}

	/**
	 * 
	 */
	public TokenEntity(String token,String expiry) {
		this.token = token;
		this.expiry = expiry;
	}

	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "TokenEntity [id=" + id + ", token=" + token + ", expiry=" + expiry + "]";
	}

}
