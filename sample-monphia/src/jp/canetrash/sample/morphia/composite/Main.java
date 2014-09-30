package jp.canetrash.sample.morphia.composite;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import com.mongodb.WriteConcern;

public class Main {

	int depth = 5;
	int count = 0;

	/**
	 * @param args
	 */
	@Test
	public void testSimple() throws Exception {
		Morphia morphia = new Morphia();
		morphia.map(Composite.class);

		MongoURI uri = new MongoURI("mongodb://192.168.0.76");
		Mongo mongo = new Mongo(uri);
		Datastore ds = morphia.createDatastore(mongo, "composite");
		ds.setDefaultWriteConcern(WriteConcern.SAFE);

		Composite entity = recursive(new Composite());
		ds.save(entity);
		Composite result = ds.find(Composite.class).field("id")
				.equal(entity.getId()).get();
		assertNotNull(result);
	}

	private Composite recursive(Composite composite) {
		count++;
		if (count == depth) {
			composite.setRank(count);
			return composite;
		}
		composite.setRank(count);
		composite.setHasChild(true);
		composite.setChild(recursive(new Composite()));
		return composite;
	}
}
