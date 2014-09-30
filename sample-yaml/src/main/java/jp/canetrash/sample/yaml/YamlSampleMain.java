package jp.canetrash.sample.yaml;

import java.io.File;

import jp.canetrash.sample.yaml.model.Entry;

import org.ho.yaml.Yaml;

public class YamlSampleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Entry entry = Yaml.loadType(new File("src/main/resources/sample.yaml"), Entry.class);
		System.out.println(entry.getApi_version());
		System.out.println(entry.getApplication());
		System.out.println(entry.getHandlers()[0].getScript());
	}

}
