package jp.canetrash.sample.spring_boot.redis.tasklet;

import jp.canetrash.sample.spring_boot.redis.service.RedisAccessService;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisBatchTasklet implements Tasklet {

	@Autowired
	private RedisAccessService service;

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {

		// redis data push
		service.push();

		// redis data pop
		String data = service.pop();

		System.out.println("##### redis pop data #####");
		System.out.println(data);

		return RepeatStatus.FINISHED;
	}

}
