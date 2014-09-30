package tutorial.agile.action;

import javax.annotation.Resource;

import org.apache.struts.action.ActionForward;
import org.slim3.struts.annotation.Execute;
import org.slim3.struts.annotation.IntegerType;
import org.slim3.struts.annotation.Required;

import tutorial.agile.service.AddService;

public class AddAction {

	@Required
	@IntegerType
	public String arg1;

	@Required
	@IntegerType
	public String arg2;

	public Integer result;

	@Resource
	protected AddService addService;

	@Execute(validate = false)
	public ActionForward index() {
		return new ActionForward("index.jsp");
	}

	@Execute(input = "index.jsp")
	public ActionForward submit() {
		result = addService.calculate(Integer.valueOf(arg1), Integer
				.valueOf(arg2));
		return new ActionForward("index.jsp");
	}
}