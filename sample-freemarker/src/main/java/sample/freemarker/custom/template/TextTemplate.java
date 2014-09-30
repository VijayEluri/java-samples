package sample.freemarker.custom.template;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public interface TextTemplate {
    void render(Map props, Writer writer) throws IOException;
}
