package jp.canetrash.sample.servlet31;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tfunato
 *
 */
@WebServlet(name = "SampleServlet", urlPatterns = {"/test"})
public class SampleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("########## Sample Servlet!");
		resp.getOutputStream().write("Hello World!".getBytes());
	}

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

}
