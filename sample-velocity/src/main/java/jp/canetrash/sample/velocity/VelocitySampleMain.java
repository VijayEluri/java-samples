package jp.canetrash.sample.velocity;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class VelocitySampleMain {

	public static void main(String[] args) {

		Velocity.init();

		VelocityContext context = new VelocityContext();

		context.put("name", new String("Velocity"));

		Template template = null;

		try {
			template = Velocity.getTemplate("template.vm");
		} catch (ResourceNotFoundException rnfe) {
			rnfe.printStackTrace();
		} catch (ParseErrorException pee) {
			pee.printStackTrace();
		} catch (MethodInvocationException mie) {
			mie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringWriter sw = new StringWriter();

		template.merge(context, sw);

		System.out.println(sw);

	}

}
