package jp.canetrash.sample.beanvalidation;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class SampleValidationTest {

	@Test
	public void testSimple() throws Exception {

		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator v = vf.getValidator();
		Bean bean = new Bean();
		bean.setStr("あいうえおカキクケコあいうえおカキクケコabcdefghijklmnopqrstu");
		bean.setStrInt("10101010");
		bean.setInteger(100);
		Calendar cl = Calendar.getInstance();
		cl.add(Calendar.YEAR, 1);
		bean.setDate2(cl.getTime());
		bean.setDate1(new Date());
		Set<ConstraintViolation<Bean>> result = v.validate(bean);
		for (ConstraintViolation<Bean> cv : result) {
			System.out.print("[" + cv.getPropertyPath() + "] ");
			System.out.print("[" + cv.getInvalidValue() + "] ");
			System.out.println("[" + cv.getMessage() + "]");
		}
	}
}
