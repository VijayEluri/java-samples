package jp.canetrash.sample.springhadoop;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class BatchMain {

	public static void main(String[] args) throws Exception {
		CommandLineJobRunner.main(new String[]{"classpath:/batch-context.xml", "wordCountJob"});
	}
}
