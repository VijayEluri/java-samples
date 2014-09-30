import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.mail.internet.MimeUtility;

import org.apache.commons.io.IOUtils;


public class DecodeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(new File("mime.txt"));
		InputStream input = MimeUtility.decode(fis, "base64");
		FileOutputStream fos = new FileOutputStream("output.jpg");
		IOUtils.copy(input, fos);
	}

}
