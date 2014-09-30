package jp.canetrash.sample.dozer;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jp.canetrash.sample.dozer.dest.BeanDest;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void testCopy() {
		Bean bean = new Bean();
		bean.setStrangeStr("違うプロパティ");

		List<Embeded> embededList = new ArrayList<Embeded>();
		bean.setEmbededList(embededList);
		Embeded embeded = new Embeded();
		embededList.add(embeded);
		embeded.setBd(new BigDecimal(999));
		embeded.setId("embededId");
		embeded.setNum(100);

		List<NestedEmbeded> nestedEmbedes = new ArrayList<NestedEmbeded>();
		NestedEmbeded nestedEmbeded = new NestedEmbeded();
		nestedEmbeded.setId("nestedEmbededId");
		nestedEmbeded.setNum(123456789);
		nestedEmbedes.add(nestedEmbeded);
		
		NestedEmbeded nestedEmbeded2 = new NestedEmbeded();
		nestedEmbeded.setId("nestedEmbededId2");
		nestedEmbeded.setNum(123456789);
		nestedEmbedes.add(nestedEmbeded2);
		
		embeded.setNestedEmbedes(nestedEmbedes);

		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		BeanDest actual = mapper.map(bean, BeanDest.class);
		assertEquals("違うプロパティ", actual.getId());
		assertEquals(1, actual.getEmbededList().size());
		assertEquals("nestedEmbededId2", actual.getEmbededList().get(0).getNestedEmbedes().get(0).getId());
		assertEquals(2, actual.getEmbededList().get(0).getNestedEmbedes().size());

	}
}
