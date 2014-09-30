package jp.canetrash.quextractor;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import jp.canetrash.quextractor.builder.DataBuilder;
import jp.canetrash.quextractor.context.Context;
import jp.canetrash.quextractor.parser.ExcelDocParser;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.collections.iterators.ListIteratorWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Executor {
    protected static final Log log = LogFactory.getLog(Executor.class);
    private Context ctx;
    private ExcelDocParser excelDocParser;
    private DataBuilder[] builders;
    private Map additionalInfoMap = new HashMap();
    private Map trafficInfoMap = new HashMap();
    
    private int BASIC_INFO_SHEET_INDEX = 1;
    private int ADDITIONAL_INFO_SHEET_INDEX = 2;
    private int TRAFFIC_INFO_SHEET_INDEX = 3;

    public DataBuilder[] getBuilders() {
        return builders;
    }

    public void setBuilders(DataBuilder[] builders) {
        this.builders = builders;
    }

    public Context getContext() {
        return ctx;
    }

    public void setContext(Context ctx) {
        this.ctx = ctx;
    }

    public ExcelDocParser getExcelDocParser() {
        return excelDocParser;
    }

    public void setExcelDocParser(ExcelDocParser excelDocParser) {
        this.excelDocParser = excelDocParser;
    }
    
    public void run() {

        // 付加情報
        log.debug("additinalInfo Sheet parse.");
        DynaBean additionalInfoSheet = (DynaBean) getExcelDocParser().parseSheet(ADDITIONAL_INFO_SHEET_INDEX, "additionalInfo");
        List additionalInfoList = (List) additionalInfoSheet.get("table");
        for (int i = 0; i < additionalInfoList.size(); i++) {
            SheetDynaBean record = (SheetDynaBean) additionalInfoList.get(i);
            additionalInfoMap.put(record.get("番号"), record);
        }
        // 交通情報
        log.debug("trafficInfo Sheet parse.");
        DynaBean trafficInfoSheet = (DynaBean) getExcelDocParser().parseSheet(TRAFFIC_INFO_SHEET_INDEX, "trafficInfo");
        List trafficInfoList = (List) trafficInfoSheet.get("table");
        for (int i = 0; i < trafficInfoList.size(); i++) {
            SheetDynaBean record = (SheetDynaBean) trafficInfoList.get(i);
            trafficInfoMap.put(record.get("id"), record);
        }

        // 基本情報
        log.debug("basicInfo Sheet parse.");
        DynaBean basicInfoSheet = (DynaBean) getExcelDocParser().parseSheet(BASIC_INFO_SHEET_INDEX, "basicInfo");
        List basicInfoList = (List) basicInfoSheet.get("table");
        for (ListIterator itr = new ListIteratorWrapper(basicInfoList.iterator()); itr.hasNext();) {
            log.debug("Record Count:" + (itr.nextIndex() + 1));
            SheetDynaBean record = (SheetDynaBean) itr.next();
            getContext().setAttribute("basicInfo", record);
            getContext().setAttribute("additionalInfo", additionalInfoMap.get(record.get("番号")));
            getContext().setAttribute("trafficInfo", trafficInfoMap.get(record.get("番号")));
            // 実行
            for (int i = 0; i< getBuilders().length; i++) {
                getBuilders()[i].execute();
            }
        }
    }
}
