package jp.canetrash.quextractor.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;

public class Table {
    private boolean colTable;
    private String name;
    private String key;
    private String col;
    private String row;
    private Map cellMap = ListOrderedMap.decorate(new HashMap());

    public Table() {
    }

    public Table(String name, String key, String col, String row) {
        this.name = name;
        this.key = key;
        this.col = col;
        this.row = row;
    }

    public boolean isColTable() {
        return colTable;
    }

    public void setTypeColTable() {
        colTable = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public void addCell(Cell cell) {
        cellMap.put(cell.getName(), cell);
    }

    public Iterator cellIterator() {
        return cellMap.values().iterator();
    }

    public List getCellList() {
        return new ArrayList(cellMap.values());
    }
    
    public void setCells(Cell[] cells) {
       if (cells == null) {
           // FIXME
           return;
       }
       for (int i = 0;i < cells.length; i++) {
           addCell(cells[i]);
       }
    }

}