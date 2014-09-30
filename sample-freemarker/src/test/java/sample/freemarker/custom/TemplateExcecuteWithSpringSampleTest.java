package sample.freemarker.custom;

import freemarker.template.Configuration;
import freemarker.template.Template;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.StringWriter;
import java.io.Writer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TemplateExcecuteWithSpringSampleTest extends TestCase {
    ApplicationContext context;
    String[] ctxFiles = { "src/main/resources/context/applicationContext.xml" };

    protected void setUp() throws Exception {
        super.setUp();
        context = new FileSystemXmlApplicationContext(ctxFiles);
    }

    public void testExcecut() throws Exception {
        TemplateExcecuteWithSpringSample exec = (TemplateExcecuteWithSpringSample) context.getBean(
                "execluter1");
        Map param = new HashMap();
        param.put("name", "Hello FreeMarker.");

        Writer writer = new StringWriter();
        exec.process(param, writer);
        assertEquals("Test Hello FreeMarker.", writer.toString());
    }

    public void testIFDirective() throws Exception {
        Configuration cfg = (Configuration) context.getBean(
                "freeMarkerConfiguration");
        assertNotNull(cfg);

        Template template = cfg.getTemplate("sampleTemplate2");
        Writer writer = new StringWriter();
        Map param = new HashMap();
        param.put("user", "Big Joe");
        template.process(param, writer);
        assertEquals("Big Joe\n", writer.toString());
    }

    public void testListDirective() throws Exception {
        Configuration cfg = (Configuration) context.getBean(
                "freeMarkerConfiguration");
        assertNotNull(cfg);

        Template template = cfg.getTemplate("sampleTemplate3");

        Map param = new HashMap();
        List list = new ArrayList();
        Being being = new Being();
        being.setName("トラ");
        list.add(being);

        being = new Being();
        being.setName("カバ");
        list.add(being);

        being = new Being();
        being.setName("ライオン");
        list.add(being);

        being = new Being();
        being.setName("ウシ");
        list.add(being);
        param.put("animals", list);

        Writer writer = new StringWriter();
        template.process(param, writer);
        assertEquals("トラ\nカバ\nライオン\nウシ\n", writer.toString());
    }

    public void testFormatBuiltIn() throws Exception {
        Configuration cfg = (Configuration) context.getBean(
                "freeMarkerConfiguration");
        assertNotNull(cfg);

        Template template = cfg.getTemplate("sampleTemplate4");

        Map param = new HashMap();
        param.put("number", new Integer(100));

        Writer writer = new StringWriter();
        template.process(param, writer);
        assertEquals("000000100", writer.toString());
    }

    public void testPaddingBuiltIn() throws Exception {
        Configuration cfg = (Configuration) context.getBean(
                "freeMarkerConfiguration");
        assertNotNull(cfg);

        Template template = cfg.getTemplate("sampleTemplate5");

        Map param = new HashMap();
        param.put("user", "test");

        Writer writer = new StringWriter();
        template.process(param, writer);
        assertEquals("AAAAAAtest", writer.toString());
    }

    public void testSimpleBean() throws Exception {
        Configuration cfg = (Configuration) context.getBean(
                "freeMarkerConfiguration");
        assertNotNull(cfg);

        Template template = cfg.getTemplate("sampleTemplate6");

        Map param = new HashMap();
        Being being = new Being();
        being.setName("シンプルなビーン");
        param.put("animal", being);

        Writer writer = new StringWriter();
        template.process(param, writer);
        assertEquals("シンプルなビーン:サンプル", writer.toString());
    }

    public class Being {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
