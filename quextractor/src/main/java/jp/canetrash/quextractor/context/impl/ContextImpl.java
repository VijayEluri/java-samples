package jp.canetrash.quextractor.context.impl;

import java.util.HashMap;
import java.util.Map;

import jp.canetrash.quextractor.context.Context;

public class ContextImpl implements Context {
    
    private Map<Object, Object> attributeMap = new HashMap<Object, Object>();

    public Object getResource(String key) {
        return attributeMap.get(key);
    }

    public void setAttribute(Object key, Object value) {
        attributeMap.remove(key);
        attributeMap.put(key, value);
    }

}
