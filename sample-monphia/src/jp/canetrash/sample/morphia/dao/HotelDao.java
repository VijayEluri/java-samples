package jp.canetrash.sample.morphia.dao;

import jp.canetrash.sample.morphia.Hotel;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;

public class HotelDao extends BasicDAO<Hotel, String> {

	public HotelDao(Class<Hotel> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

}
