package tutorial.agile.action;

import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;
import org.slim3.commons.web.WebLocator;
import org.slim3.struts.annotation.Execute;
import org.slim3.struts.annotation.Required;
import org.slim3.struts.util.UploadUtil;

public class UploadAction {

	@Required
	public FormFile formFile;

	@Execute(validate = false)
	public ActionForward index() {
		UploadUtil.checkSizeLimit();
		return new ActionForward("index.jsp");
	}

	@Execute(input = "index.jsp")
	public ActionForward upload() {
		String path = WebLocator.getServletContext().getRealPath(
				"/WEB-INF/work/" + formFile.getFileName());
		UploadUtil.write(path, formFile);
		return new ActionForward("index.jsp");
	}
}