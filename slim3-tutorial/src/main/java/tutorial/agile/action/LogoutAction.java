package tutorial.agile.action;

import org.apache.struts.action.ActionForward;
import org.slim3.commons.web.WebLocator;
import org.slim3.struts.annotation.Execute;

public class LogoutAction {

	@Execute(validate = false)
	public ActionForward index() {
		WebLocator.getRequest().getSession().invalidate();
		return new ActionForward("index.jsp");
	}
}