package jp.canetrash.sample.csv;

import java.sql.Timestamp;

import org.seasar.s2csv.csv.annotation.column.CSVColumn;
import org.seasar.s2csv.csv.annotation.column.CSVConvertor;
import org.seasar.s2csv.csv.annotation.column.CSVDateType;
import org.seasar.s2csv.csv.annotation.entity.CSVEntity;
import org.seasar.s2csv.csv.convertor.CSVDateConvertor;

@CSVEntity(header=false,columnCountCheck=false)
public class LicenceCsv {

    @CSVColumn(columnIndex=0)
    public Long retailId;

    @CSVColumn(columnIndex=1)
    public String licence;

    @CSVColumn(columnIndex=2)
    public String appVersion;

    @CSVColumn(columnIndex=3)
    public String loaderVersion;

    @CSVColumn(columnIndex=4)
    @CSVConvertor(convertor=CSVDateConvertor.class,convertSetProp="pattern=yyyy/MM/dd HH:mm:ss")
    @CSVDateType(datePattern="yyyy/MM/dd HH:mm:ss")
    public Timestamp contentsLastDate;

    @CSVColumn(columnIndex=5)
    @CSVConvertor(convertor=CSVDateConvertor.class,convertSetProp="pattern=yyyy/MM/dd HH:mm:ss")
    @CSVDateType(datePattern="yyyy/MM/dd HH:mm:ss")
    public Timestamp mobileContentsLastDate;
}
