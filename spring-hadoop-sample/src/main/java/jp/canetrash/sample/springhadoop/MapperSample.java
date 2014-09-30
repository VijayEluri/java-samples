package jp.canetrash.sample.springhadoop;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperSample extends Mapper<LongWritable, Text, Text, IntWritable> {

	  private final static IntWritable one = new IntWritable(1);
	  private  Text word = new Text();
		
	  @Override
	  public void map(LongWritable key, Text value, Context context)
	      throws IOException, InterruptedException {

	        StringTokenizer itr = new StringTokenizer(value.toString());
	        while (itr.hasMoreTokens()) {
	        	String val = itr.nextToken();
	            word.set(val);
	            context.write(word, one);
	        }
	  }
}
