package jp.canetrash.sample.springhadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class OutputFormatSample extends FileOutputFormat<Text, IntWritable> {

	protected static class LineRecordWriter<K, V> extends RecordWriter<K, V> {

		public synchronized void write(K key, V value) throws IOException {

			System.out.println(key.toString() + "	" + value.toString());
		}

		public synchronized void close(TaskAttemptContext context)
				throws IOException {
		}
	}

	public RecordWriter<Text, IntWritable> getRecordWriter(
			TaskAttemptContext job) throws IOException, InterruptedException {
		return new LineRecordWriter<Text, IntWritable>();
	}
}
