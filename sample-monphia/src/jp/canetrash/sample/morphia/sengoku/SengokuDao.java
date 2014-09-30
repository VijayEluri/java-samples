package jp.canetrash.sample.morphia.sengoku;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;

public class SengokuDao extends BasicDAO<Daimyou, ObjectId> {

	public SengokuDao(Class<Daimyou> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

}
