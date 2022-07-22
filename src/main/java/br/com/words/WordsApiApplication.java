package br.com.words;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WordsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordsApiApplication.class, args);
	}
}
