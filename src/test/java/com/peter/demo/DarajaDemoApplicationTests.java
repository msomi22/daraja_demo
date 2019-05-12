package com.peter.demo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.peter.demo.controller.EntityService;
import com.peter.demo.entity.TokenEntity;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DarajaDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EntityService entityService;

	@Test
	public void findAll() throws Exception {
		

		List<TokenEntity> tentities = new ArrayList<>();
		
		TokenEntity entity1 = new TokenEntity("tekn_string","12345");
		tentities.add(entity1);
		
		TokenEntity entity2 = new TokenEntity("tekn_string","12345");
		tentities.add(entity2);
	
		when(entityService.findAll()).thenReturn(Arrays.asList(entity1, entity2));
		
		given(entityService.findAll()).willReturn(tentities);

		this.mockMvc.perform(get("/tokens")).andExpect(status().isOk())
		.andExpect(content().
				json("[\r\n" + 
						"    {\r\n" + 
						"        \"id\": 1,\r\n" + 
						"        \"token\": \"tSmDp3RKd6yUxLhT7EuGtGjFsHh2\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 2,\r\n" + 
						"        \"token\": \"AnqSwi0y4qAqUmKRAtXVSArNtP1N\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 3,\r\n" + 
						"        \"token\": \"OLrwVMJVqUngApaJ0zNG3rFkmY8I\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 4,\r\n" + 
						"        \"token\": \"fFIS4G0LAx6csmDMUz3h5WAZzsib\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 5,\r\n" + 
						"        \"token\": \"8nrWZkErExVn7upGzbN47ERY1qlz\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 6,\r\n" + 
						"        \"token\": \"soGqtv7MWNDV8jNfSNsGXWN9HP55\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 7,\r\n" + 
						"        \"token\": \"FIqjfKZLJ32EuPHVx5jGw3v4iNgL\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 8,\r\n" + 
						"        \"token\": \"DDlhD3AVIeVgpSgowINjIxvm4Ktw\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 9,\r\n" + 
						"        \"token\": \"v0r3Bxv3fmeqNIHjObLwX5RglRHt\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 10,\r\n" + 
						"        \"token\": \"d0OjknnEnAqLG4TlcogwT5AcU4MJ\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 11,\r\n" + 
						"        \"token\": \"guqrL5VvsU5Ja6FvYGaGAHtZjker\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 12,\r\n" + 
						"        \"token\": \"TD0NgPAd3BeX7blicSY4GWbmrf3D\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 13,\r\n" + 
						"        \"token\": \"d97GjG8SZ6NdkXCgiLR1RwcKI9uz\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 14,\r\n" + 
						"        \"token\": \"iJW03EVxtq6gt8nfaO7YxrMNciho\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 15,\r\n" + 
						"        \"token\": \"tANeirLm6wkqKetBlvMmbGvd8ujh\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 16,\r\n" + 
						"        \"token\": \"yCowLK2cNB59OOFLI7r4B2gULtQU\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 17,\r\n" + 
						"        \"token\": \"eALH8mz9TxBhMCvEHT1E7g93mx1g\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 18,\r\n" + 
						"        \"token\": \"LGxKF4GqDVyskZOwjv6xqNu0sDhG\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 19,\r\n" + 
						"        \"token\": \"FRwWCMGXWs3ihNNYK8TjvAqK1jcI\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 20,\r\n" + 
						"        \"token\": \"yyFfIyaWxrGT1yLT3Xqy5wb7K22f\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 21,\r\n" + 
						"        \"token\": \"dycREz1TYCLWSQJh9MZ81ssWfG9s\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 22,\r\n" + 
						"        \"token\": \"Rtwo70AksRnWzz7QbMTjMT70GBbu\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    },\r\n" + 
						"    {\r\n" + 
						"        \"id\": 23,\r\n" + 
						"        \"token\": \"PViYIPLkTIJeOLzObGbNsSR0KhXA\",\r\n" + 
						"        \"expiry\": \"3599\"\r\n" + 
						"    }\r\n" + 
						"]"));

	}

}
