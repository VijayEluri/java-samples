package sample.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class HelloWorldApplication extends WebApplication {

    /**
     * @see wicket.protocol.http.WebApplication#init()
     */
    protected void init() {
        super.init();
        getRequestCycleSettings().setResponseRequestEncoding( "UTF-8");
        getMarkupSettings().setDefaultMarkupEncoding( "Shift_JIS");
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HelloWorld.class;
    }

}
