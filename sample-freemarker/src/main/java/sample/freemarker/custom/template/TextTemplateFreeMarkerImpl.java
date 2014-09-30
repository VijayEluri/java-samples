package sample.freemarker.custom.template;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TextTemplateFreeMarkerImpl implements TextTemplate {
    private Configuration configuration;
    private String templateName;
    
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public void render(Map props, Writer writer) throws IOException {
        Template template = getConfiguration().getTemplate(getTemplateName());
        try {
            template.process(props, writer);
            writer.flush();
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } 
    }
}
