package jp.canetrash.sample.morphia.sengoku;

import java.util.Date;

import org.junit.Test;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

public class RunTest {

	@Test
	public void testSimple() throws Exception {
		Morphia morphia = new Morphia();
		morphia.map(Daimyou.class);

		MongoURI uri = new MongoURI("mongodb://192.168.0.76");
		Mongo mongo = new Mongo(uri);
		Datastore ds = morphia.createDatastore(mongo, "sengoku");
		SengokuDao dao = new SengokuDao(Daimyou.class, ds);
		Query<Daimyou> query = dao.createQuery();

		Date date = new Date();
		System.out.println(date);
		query.field("period.start").lessThan(date);

		QueryResults<Daimyou> find = dao.find(query);
		System.out.println(find.countAll());
		Daimyou entity = find.get();
		System.out.println(entity.getName());
		System.out.println(entity.getTerritory());
		System.out.println(entity.getPeriod().get(0).getStart());
		System.out.println(entity.getPeriod().get(0).getEnd());
	}
}
