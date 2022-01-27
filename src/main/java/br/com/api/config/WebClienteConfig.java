package br.com.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClienteConfig {
	
	@Bean
	public WebClient webClient(WebClient.Builder builder) {

		return builder
				.baseUrl("https://jsonplaceholder.typicode.com")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
		
	}

}
