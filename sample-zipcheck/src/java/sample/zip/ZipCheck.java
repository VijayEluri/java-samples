package sample.zip;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * Zipファイルをチェックする
 */
public class ZipCheck {

    public static boolean checkZipFile(String file) {
        return checkZipFile(new File(file));
    }
    
    public static boolean checkZipFile(File file) {
        try { 
            new ZipFile(file);
            return true;
        } catch (ZipException ex) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
