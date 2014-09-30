package sample.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * Hello freemaker!
 *
 */
public class FreeMarkerSimpleSample 
{
    public void process() {

        Configuration cfg = new Configuration();
        try {
            // XXX �����ł̓f�B���N�g����ݒ肵�Ă��邪TemplateLoader�������������̂�n����
            // �������g����悤��
            cfg.setDirectoryForTemplateLoading( new File("src/main/resources/templates"));
        } catch (IOException e) {
           throw new RuntimeException(e); 
        }
        cfg.setObjectWrapper(new DefaultObjectWrapper()); 
        // �f�[�^�̗p��
        Map root = new HashMap();
        root.put("user", "Big Joe");

        Map latest = new HashMap();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse"); 
        
        
        // �e���v���[�g�̎擾
        Template temp = null;
        try {
            temp = cfg.getTemplate("sample.ftl");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        // ���s
        Writer out = new OutputStreamWriter(System.out);
        try { 
            temp.process(root, out);
            out.flush();  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
