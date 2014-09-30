package sample.wicket;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;

public class HelloWorld extends WebPage {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

    /**
     * Constructor
     */
    public HelloWorld() {
        add(new Label("message", new AbstractReadOnlyModel() {
            @Override
            public Object getObject() {
                Date date = new Date();
                return sdf.format(date);
            }

        }));
        createForm();

    }

    private void createForm() {
        // フォームを作成してページに追加
        Form form = new Form("form");
        final TextField txtFld = new TextField("textField", new Model());
        txtFld.setRequired(true);
        form.add(txtFld);
        form.add(new Button("submitBtn") {
            @Override
            public void onSubmit() {
                Component txtField = this.getParent().get( "textField");
                String newStr = txtField.getModelObjectAsString();
                info( "入力値は: " + newStr);
            }
        });
        super.add(form);
        
        add(new FeedbackPanel("feedback"));

    }
}
