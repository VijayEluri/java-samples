package sample.wicket;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Application;
import org.apache.wicket.Request;
import org.apache.wicket.protocol.http.WebSession;

public class ExampleSession extends WebSession {

    public ExampleSession(Application application, Request request) {
        super(application, request);
    }

    private Map<String, Object> dataMap = new HashMap<String, Object>();

    public Object get(String aKey) {
        return this.dataMap.get(aKey);
    }

    public void put(String aKey, Object anObject) {
        this.dataMap.put(aKey, anObject);
    }

}
