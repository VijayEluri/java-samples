package jp.canetrash.sample.poi;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * XLSX形式でExcelファイルを作成するテスト
 * 
 * @author tfunato
 * 
 */
public class XLSXSample {

	/**
	 * @throws Exception
	 */
	public void makeXlsxFile() throws Exception {
		String fileName = "test.xlsx";
		FileOutputStream fileOut = new FileOutputStream(fileName);
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("test"); // シート作成
		Row row = sheet.createRow((short)0);
		Cell cell = row.createCell(0);
		cell.setCellValue("日本語は通る？");
		wb.write(fileOut);
		fileOut.close();
	}
}
