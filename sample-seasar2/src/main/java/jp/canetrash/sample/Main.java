package jp.canetrash.sample;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Timestamp;

import jp.canetrash.sample.csv.LicenceCsv;
import jp.canetrash.sample.csv.LicenceReadCsv;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.s2csv.csv.S2CSVParseCtrl;
import org.seasar.s2csv.csv.S2CSVWriteCtrl;
import org.seasar.s2csv.csv.factory.S2CSVCtrlFactory;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        SingletonS2ContainerFactory.setConfigPath("app.dicon");
        SingletonS2ContainerFactory.init();
        S2Container container = SingletonS2ContainerFactory.getContainer();
        S2CSVCtrlFactory csvFactory = (S2CSVCtrlFactory)container.getComponent(S2CSVCtrlFactory.class);
        Reader reader = new FileReader(new File("licence.csv"));
        S2CSVParseCtrl<LicenceReadCsv> parseController = csvFactory.getParseController(LicenceReadCsv.class, reader);
        S2CSVWriteCtrl<LicenceCsv> writeController = csvFactory.getWriteController(LicenceCsv.class, new FileWriter(new File("write.csv")));
        
        LicenceCsv writeCsv = new LicenceCsv();
        writeCsv.retailId = 1L;
        writeCsv.licence = "Xl6Yvc/7SSFguqmXnI1mUHOXkEvzwbBtld5ZlgV+lTg=";
        writeCsv.appVersion = "1.1.6";
        writeCsv.loaderVersion = "1.1.0";
        writeCsv.contentsLastDate = new Timestamp(System.currentTimeMillis());
        writeController.write(writeCsv);
        writeController.close();
        while(parseController.readNext()) {
            LicenceReadCsv csv = parseController.parse();
            System.out.println(csv);
        }

    }

}
