package sample.freemarker.custom.loader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.TemplateLoader;

public class SimpleFreeMarkerResourceLoader implements TemplateLoader {
    
    private Map resources = new HashMap();
    private long lastModified = System.currentTimeMillis();
    
    public Map getResources() {
        return resources;
    }
    public void setResources(Map resources) {
        this.resources = resources;
    }

    /**
     * {@inheritDoc}
     */
    public Object findTemplateSource(String name) throws IOException {
        return resources.get(name);
    }

    /**
     * {@inheritDoc}
     */
    public long getLastModified(Object templateSource) {
        return lastModified;
    }

    /**
     * {@inheritDoc}
     */
    public Reader getReader(Object templateSource, String encoding) throws IOException {
        if ( templateSource instanceof String) {
            return new StringReader((String)templateSource);
        } else {
            throw new RuntimeException("Can't support");
        }
    }

    /**
     * {@inheritDoc}
     */
    public void closeTemplateSource(Object templateSource) throws IOException {
        // nothing to do.
    }

}
