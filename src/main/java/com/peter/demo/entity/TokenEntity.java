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

	/**
	 * 
	 */
	public TokenEntity(String token,String expiry) {
		this.token = token;
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		return "TokenEntity [id=" + id + ", token=" + token + ", expiry=" + expiry + "]";
	}

}
