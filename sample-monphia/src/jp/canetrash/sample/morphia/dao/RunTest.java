package jp.canetrash.sample.morphia.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import jp.canetrash.sample.morphia.Address;
import jp.canetrash.sample.morphia.Hotel;
import jp.canetrash.sample.morphia.Util;

import org.junit.Test;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;

public class RunTest {

	/**
	 */
	@Test
	public void testSimple() throws Exception {

		Morphia morphia = new Morphia();
		morphia.map(Hotel.class).map(Address.class);

		Datastore ds = Util.getDataStore(morphia, "daotest");
		HotelDao dao = new HotelDao(Hotel.class, ds);
		Hotel entity = new Hotel();
		Address addr = new Address();
		entity.setAddress(addr);
		entity.setDate(new Date());
		entity.setName("ホテル");
		entity.setStars(5);
		dao.save(entity);
		Hotel hotel = dao.createQuery().field("id").equal(entity.getId()).get();
		assertNotNull(hotel);
		assertEquals("ホテル", hotel.getName());
		assertEquals(1, dao.count());
		assertEquals(5, hotel.getStars());
		dao.deleteByQuery(dao.createQuery());
	}
}
