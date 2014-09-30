package jp.canetrash.maven.plugin.twitter;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.io.InputStreamReader;

import net.unto.twitter.Api;
import net.unto.twitter.TwitterException;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * Maven Twit Plugin
 * 
 * @goal twit
 */
public class TwitMojo extends AbstractTwitterMojo {

	public void execute() throws MojoExecutionException {
		System.out.print("Twit:>");
		StringBuilder sb = new StringBuilder();
		try {
			InputStreamReader fp = new InputStreamReader(System.in);
    		int i = 0;
			while (true) {
				i = fp.read();
				if (i == '\n') {
					break;
				}
				sb.append((char) i);
			}
			fp.close();
		} catch (IOException e) {
			throw new MojoExecutionException("Error", e);
		}
		try {
    		Api api = new Api(twitterUsername, twitterPassword);
			api.updateStatus(sb.toString());
		} catch (TwitterException e) {
			e.printStackTrace();
			throw new MojoExecutionException("Error updateStatus", e);
		}
	}
}
