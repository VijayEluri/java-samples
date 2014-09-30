// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.xfire.handler;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;
import org.jdom.Namespace;

public class CheckVersionHandler extends AbstractHandler {
    private static final String VERSION_TAG = "version";

    private static final String VERSION_NS = "http://xfire.codehaus.org/Book";

    public void invoke(MessageContext ctx) throws Exception {
        // Check if header exists
        Element header = ctx.getInMessage().getHeader();
        if (header == null) {
            throw new XFireRuntimeException("Missing SOAP header");
        }
        // Does it have version tag
        Element version = header.getChild(VERSION_TAG, Namespace
                .getNamespace(VERSION_NS));
        if (version == null) {
            throw new XFireRuntimeException("Missing version header");
        }

        ctx.setProperty("ServiceVersion", version.getText());
    }

}
