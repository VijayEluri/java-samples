package jp.canetrash.quextractor.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;

public class Sheet {
    private String name;
    private Map cellMap = ListOrderedMap.decorate(new HashMap());
    private Map tableMap = ListOrderedMap.decorate(new HashMap());

    public Sheet() {

    }

    public Sheet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCell(Cell cell) {
        cellMap.put(cell.getName(), cell);
    }

    public Iterator cellIteraotr() {
        return cellMap.values().iterator();
    }

    public List getCellList() {
        return new ArrayList(cellMap.values());
    }

    public void addTable(Table table) {
        tableMap.put(table.getName(), table);
    }

    public void setRowTable(Table table) {
        tableMap.put(table.getName(), table);
    }

    public void setColTable(Table table) {
        table.setTypeColTable();
        tableMap.put(table.getName(), table);
    }

    public Iterator tableIteraotr() {
        return tableMap.values().iterator();
    }

    public List getTableList() {
        return new ArrayList(tableMap.values());
    }

}