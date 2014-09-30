package sample.freemarker.custom;

import java.io.Writer;
import java.util.Map;

import sample.freemarker.custom.template.TextTemplate;

public class TemplateExcecuteWithSpringSample {
    private TextTemplate template;

    public TextTemplate getTemplate() {
        return template;
    }

    public void setTemplate(TextTemplate template) {
        this.template = template;
    }
    
    public void process(Map param, Writer writer) throws Exception {
        getTemplate().render(param, writer);
    }

}
