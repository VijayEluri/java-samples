package jp.canetrash.sample.servlet31;

import java.io.IOException;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * 非同期サーブレット
 * 
 * @author tfunato
 * 
 */
@WebServlet(name = "AsyncServlet", urlPatterns = "/async", asyncSupported = true)
@MultipartConfig(location="/tmp/files", maxFileSize=1000000, maxRequestSize=1000000, fileSizeThreshold=1000000)
public class SampleAsyncServlet extends HttpServlet {

	/**  */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//Part part = req.getPart("file");
		//part.write("hogehoge");

		// start async
		AsyncContext ac = req.startAsync();
		// set up async listener
		System.out.println("process start:" + new Date());
		ac.addListener(new AsyncListener() {
			public void onComplete(AsyncEvent event) throws IOException {
				event.getSuppliedResponse().getOutputStream()
						.print("Async Request Complete");
			}

			public void onError(AsyncEvent event) {
				System.out.println("onError:" + event.getThrowable());
			}

			public void onStartAsync(AsyncEvent event) {
				System.out.println("AsyncStart!");
			}

			public void onTimeout(AsyncEvent event) {
				System.out.println("my asyncListener.onTimeout");
			}
		});

		// set up ReadListener to read data for processing
		ServletInputStream input = req.getInputStream();
		ReadListener readListener = new ReadListenerImpl(input, resp, ac);
		input.setReadListener(readListener);
		System.out.println("process end:" + new Date());

		resp.getOutputStream().write("Hello Async World!".getBytes());
	}

}

class ReadListenerImpl implements ReadListener {
	private ServletInputStream input = null;
	private HttpServletResponse res = null;
	private AsyncContext ac = null;
	// store the processed data to be sent back to client later
	private Queue queue = new LinkedBlockingQueue();

	ReadListenerImpl(ServletInputStream in, HttpServletResponse r,
			AsyncContext c) {
		input = in;
		res = r;
		ac = c;
	}

	public void onDataAvailable() throws IOException {
		StringBuilder sb = new StringBuilder();
		int len = -1;
		byte b[] = new byte[1024];
		// We need to check input#isReady before reading data.
		// The ReadListener will be invoked again when
		// the input#isReady is changed from false to true
		while (input.isReady() && (len = input.read(b)) != -1) {
			String data = new String(b, 0, len);
			sb.append(data);
		}
		queue.add(sb.toString());
	}

	public void onAllDataRead() throws IOException {
		// now all data are read, set up a WriteListener to write
		ServletOutputStream output = res.getOutputStream();
		WriteListener writeListener = new WriteListenerImpl(output, queue, ac);
		output.setWriteListener(writeListener);
	}

	public void onError(final Throwable t) {
		ac.complete();
		t.printStackTrace();
	}
}

class WriteListenerImpl implements WriteListener {
	private ServletOutputStream output = null;
	private Queue queue = null;
	private AsyncContext ac = null;

	WriteListenerImpl(ServletOutputStream sos, Queue q, AsyncContext c) {
		output = sos;
		queue = q;
		ac = c;
	}

	public void onWritePossible() throws IOException {
		// write while there is data and is ready to write
		while (queue.peek() != null && output.isReady()) {
			String data = (String)queue.poll();
			output.print(data);
		}
		// complete the async process when there is no more data to write
		if (queue.peek() == null) {
			ac.complete();
		}
	}

	public void onError(final Throwable t) {
		ac.complete();
		t.printStackTrace();
	}
}