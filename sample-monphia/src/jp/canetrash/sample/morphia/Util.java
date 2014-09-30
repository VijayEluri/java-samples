package jp.canetrash.sample.morphia;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import com.mongodb.WriteConcern;

public class Util {

	public static Datastore getDataStore(Morphia morphia, String db) {

		try {
			MongoURI uri = new MongoURI("mongodb://192.168.0.76");
			Mongo mongo;
			mongo = new Mongo(uri);
    		Datastore ds = morphia.createDatastore(mongo, db);
    		ds.setDefaultWriteConcern(WriteConcern.SAFE);
    		return ds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
