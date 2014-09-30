package jp.canetrash.sample.zxing;

import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

public class SampleMain {

	public static void main(String[] args) throws Exception {
		Code128Writer matrixWriter = new Code128Writer();
		BitMatrix bitMatrix = matrixWriter.encode("123456789", BarcodeFormat.CODE_128, 100, 50);
		MatrixToImageWriter.writeToFile(bitMatrix, "JPG", new File("test.jpg"));
	}
}
