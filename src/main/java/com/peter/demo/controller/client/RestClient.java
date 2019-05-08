package com.peter.demo.controller.client;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.peter.demo.bean.Response;
import com.peter.demo.bean.Token;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * 
 * @author t_pnjeru
 *
 */
@Component
public class RestClient {

	private final String CONSUMER_KEY = System.getenv("CONSUMER_KEY");
	private final String CONSUMER_SECRET =  System.getenv("CONSUMER_SECRET");

	public Object getAccessToken() {

		String url = "https://sandbox.safaricom.co.ke/oauth/v1/generate";
		
		if(CONSUMER_KEY == null || CONSUMER_SECRET == null) {
			return new Response(404, "Key not found");
		}
		
		
		String authEncoded = getAuthBase64(CONSUMER_KEY, CONSUMER_SECRET); 

		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);

		ClientResponse resp = webResource. queryParam("grant_type",
				"client_credentials"). accept("application/json") .header("Authorization",
						"Basic " + authEncoded).get(ClientResponse.class);

		if (resp.getStatus() != 200) {
			System.err.println("Unable to connect to the server"); 
		}

		String output = resp.getEntity(String.class);
		System.out.println(output);

		Gson g = new Gson();
		Token token = g.fromJson(output, Token.class);

		return token;
	}



	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private String getAuthBase64(String username, String password) {
		String authEncoded = "";
		String auth = username + ":" + password;
		try {
			authEncoded = Base64.getEncoder().encodeToString(auth.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return authEncoded;
	}

	/**
	 * @param string
	 * @param authEncoded
	 * @return
	 */
	private String generatePassword(String shortCode, String lnmPasskey, String timestamp) {
		String passcode = shortCode + lnmPasskey + timestamp;
		byte[] passcodeBteArray = passcode.getBytes();
		String encoded = Base64.getEncoder().withoutPadding().encodeToString(passcodeBteArray);
		return encoded;
	}

	/**
	 * 
	 * @return
	 */
	private String generateCurrentTime() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Timestamp now = new Timestamp(System.currentTimeMillis());
		return sdf.format(now);
	}


}
