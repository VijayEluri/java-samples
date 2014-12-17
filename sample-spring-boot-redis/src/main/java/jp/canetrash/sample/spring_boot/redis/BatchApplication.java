package jp.canetrash.sample.spring_boot.redis;

import jp.canetrash.sample.spring_boot.redis.tasklet.RedisBatchTasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 * 
 */
@SpringBootApplication
@ImportResource(value="classpath:applicationContext.xml")
@EnableBatchProcessing
public class BatchApplication {
	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Autowired
	private RedisBatchTasklet tasklet;

	@Bean
	public Job job() throws Exception {
		return this.jobs.get("job").start(step1()).build();
	}

	@Bean
	protected Step step1() throws Exception {
		return this.steps.get("step1").tasklet(tasklet).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
}
