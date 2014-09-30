package jp.canetrash.quextractor.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;

public class SheetConfig {
    private Map sheetMap = ListOrderedMap.decorate(new HashMap());

    public void addSheet(Sheet sheet) {
        sheetMap.put(sheet.getName(), sheet);
    }

    public Sheet findSheet(String name) {
        return (Sheet) sheetMap.get(name);
    }

    public Iterator iterator() {
        return sheetMap.values().iterator();
    }

    public List getSheetList() {
        return new ArrayList(sheetMap.values());
    }
    
    public void setSheets(Sheet[] sheets) {
        if (sheets == null) {
            // FIXME
            return;
        }
        for (int i = 0; i < sheets.length; i++ ) {
            addSheet(sheets[i]);
        }
    }

}
