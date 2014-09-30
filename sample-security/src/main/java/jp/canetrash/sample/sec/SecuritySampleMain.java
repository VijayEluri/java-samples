package jp.canetrash.sample.sec;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class SecuritySampleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("sun.nio.cs.map", "x-windows-iso2022jp/ISO-2022-JP");

		Runnable outerClass = null;
		try {
			ClassLoader cl = new URLClassLoader(new URL[] { new File(
					"/Users/tfunato/Documents/workspace/sample-security/target/classes/jp/canetrash/sample/sec/OuterClass.class").toURL() });
			Class cls = cl.loadClass("jp.canetrash.sample.sec.OuterClass");
			outerClass = (Runnable) cls.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		outerClass.run();
		System.out.println("Run as it.");
	}

}
