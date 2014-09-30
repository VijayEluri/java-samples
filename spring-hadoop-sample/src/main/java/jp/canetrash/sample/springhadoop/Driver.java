package jp.canetrash.sample.springhadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Driver extends Configured implements Tool {
	public static void main(String[] args) throws Exception {

		/*
		 * Validate that two arguments were passed from the command line.
		 */
		int res = ToolRunner.run(new Configuration(), new Driver(), args);
		System.out.println(res);
	}

	//@Override
	public int run(String[] arg0) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);

		job.setJarByClass(Driver.class);

		job.setJobName("Stub Driver");

		job.setMapperClass(MapperSample.class);
		job.setReducerClass(ReducerSample.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputFormatClass(OutputFormatSample.class);
		job.setInputFormatClass(InputFormatSample.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path( "hdfs://cloudera-hadoop/user/tfunato/test.txt"));
		FileOutputFormat.setOutputPath(job, new Path( "hdfs://cloudera-hadoop/user/tfunato/output"));

		boolean success = job.waitForCompletion(true);

		return (success ? 0 : 1);
	}
}
