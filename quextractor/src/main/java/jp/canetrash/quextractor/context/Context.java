package jp.canetrash.quextractor.context;


public interface Context {
    Object getResource(String key);
    
    void setAttribute(Object key, Object obj);
}
