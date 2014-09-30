package jp.canetrash.maven.plugin.bijint;

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

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.xml.transform.TransformerException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xpath.internal.XPathAPI;

/**
 * Bijin Tokei maven plugin
 * 
 * @auther tfunato
 * @goal touch
 * @requiresProject false
 */
public class BujintMojo extends AbstractMojo {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException {

		try {
		    String imgUrl = nowTimeImageUrl();
		    if (imgUrl == null) {
		        return;
		    }

    		// 表示
    		getLog().info("\n" + getAsciiArt(getFittingImage(imgUrl)));

		} catch (Exception e) {
		    e.printStackTrace();
		    throw new MojoExecutionException("なんかエラー", e);
		}
	}

    /**
     * @param image
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     * @throws UnsupportedEncodingException
     */
    private String getAsciiArt(BufferedImage image) throws IOException,
            ClientProtocolException, UnsupportedEncodingException {
        File tmpfile = File.createTempFile("bjint_", ".jpg");
        ImageIO.write(image, "jpg", tmpfile);

        // http://picascii.com/へ画像をポストする
        // いったんセッションクッキーを書き込む
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://picascii.com/");
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        entity.consumeContent();

        // 画像をポストする
        HttpPost httppost = new HttpPost("http://picascii.com/upload.php");
        //HttpPost httppost = buildDefaultHttpMessage(new HttpPost("http://localhost:8080/sa-struts-tutorial/upload/"));

        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        FileBody bin = new FileBody(tmpfile, "image/jpeg");
        reqEntity.addPart("imageupload", bin);
        reqEntity.addPart("MAX_FILE_SIZE", new StringBody("1000000"));
        reqEntity.addPart("url", new StringBody(""));
        reqEntity.addPart("quality", new StringBody("3"));
        reqEntity.addPart("size", new StringBody("1"));

        httppost.setEntity(reqEntity);

        response = httpclient.execute(httppost);
        String responseHtml = IOUtils.toString(response.getEntity().getContent());

        httpclient.getConnectionManager().shutdown();

        // tmpFileを削除する
        tmpfile.delete();
        return bringOutAsciiArtString(responseHtml);
    }

	/**
	 * 結果HTMLからアスキーアート部分を取り出す
	 * @param str 文字列
	 * @return アスキーアート
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws TransformerException 
	 */
	private String bringOutAsciiArtString(String str) {
		// 結果のHTMLをパースしてAAだけ抜き出す
		String aa = null;
		DOMParser parser = new DOMParser();
		try { 
    		parser.setFeature("http://xml.org/sax/features/namespaces", false);
    		parser.parse(new InputSource(new StringReader(str)));
    		NodeList nodeList = XPathAPI.selectNodeList(parser.getDocument(), "/HTML/BODY/PRE");
    		for (int i = 0; i < nodeList.getLength(); i++) {
    			Element element = (Element) nodeList.item(i);
    			aa = element.getTextContent();
    		}
		} catch (Exception e) {
		    throw new RuntimeException(e);
        }
		return aa;
	    
	}
	/**
	 * http://www.bijint.com/ にアクセスして画像のURLを取得する
	 * 
	 * @return 画像のURL
	 */
	String nowTimeImageUrl() throws Exception {
	    String time = DateFormatUtils.format(new Date(), "hhmm");
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = buildDefaultHttpMessage(new HttpGet("http://www.bijint.com/cache/"+ time + ".html"));
		httpget.setHeader("Referer", "http://www.bijint.com/jp/");
		HttpResponse response = httpclient.execute(httpget);
		if (response.getStatusLine().getStatusCode() != 200) {
		    getLog().error("美人時計忙しいらしいよ。なんか２００じゃないの返してくる。");
		    return null;
		}
		String result = IOUtils.toString(response.getEntity().getContent(),
				"UTF-8");
		httpclient.getConnectionManager().shutdown();

		return "http://www.bijint.com" + getImagePath(result);
	}

	/**
	 * HTMLをパースして該当画像のパスを取得する
	 * 
	 * @param str
	 * @return path
	 * @throws Exception
	 */
	String getImagePath(String str) throws Exception {
		DOMParser parser = new DOMParser();
		parser.parse(new InputSource(new StringReader(str)));
		NodeList nodeList = XPathAPI.selectNodeList(parser.getDocument(),
				"/HTML/BODY/TABLE/TR/TH[1]/IMG");
		String path = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			path = element.getAttribute("src");
		}
		return path;
	}

	/**
	 * 適切な大きさにした画像を返す
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	BufferedImage getFittingImage(String url) throws Exception {
		// 画像を縮小
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = buildDefaultHttpMessage(new HttpGet(url));
		httpget.setHeader("Referer", "http://www.bijint.com/jp/");
		HttpResponse response = httpclient.execute(httpget);

		BufferedImage image = ImageIO.read(response.getEntity().getContent());
		httpclient.getConnectionManager().shutdown();

		int width = image.getWidth() / 10 * 4;
		int height = image.getHeight() / 10 * 4;
		BufferedImage resizedImage = null;
		resizedImage = new BufferedImage(width, height, image.getType());
		resizedImage.getGraphics().drawImage(
				image.getScaledInstance(width, height,
						Image.SCALE_AREA_AVERAGING), 0, 0, width, height, null);
		return resizedImage;
	}

	private <T extends HttpMessage> T buildDefaultHttpMessage(T message) {
		message.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; ja; rv:1.9.0.6)");
		message.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=9,*/*;q=0.8");
        message.addHeader("Accept-Language", "ja,en-us;q=0.7,en;q=0.3");
        message.addHeader("Accept-Encoding", "gzip,deflate");
		message.setHeader("Keep-Alive", "300");
		return message;
	}
}
