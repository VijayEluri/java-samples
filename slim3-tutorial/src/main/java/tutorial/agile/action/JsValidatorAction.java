package tutorial.agile.action;

import org.apache.struts.action.ActionForward;
import org.slim3.struts.annotation.Execute;
import org.slim3.struts.annotation.Required;

public class JsValidatorAction {

	@Required(targets = "submit")
	public String aaa;

	@Required(targets = "submit2")
	public String bbb;

	@Execute(validate = false)
	public ActionForward index() {
		return new ActionForward("index.jsp");
	}

	@Execute(input = "index.jsp")
	public ActionForward submit() {
		return new ActionForward("index.jsp");
	}

	@Execute(input = "index.jsp")
	public ActionForward submit2() {
		return new ActionForward("index.jsp");
	}
}