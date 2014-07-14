package jp.canetrash.sample.spring_io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * FreeMarkerを使ったWebアプリのSpring IO、Spring Bootサンプル
 * @author tfunato
 * 
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
}
