package jp.canetrash.sample.morphia.link;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

public class RunTest {

	/**
	 * @param args
	 */
	@Test
	public void testSimple() throws Exception {
		Morphia morphia = new Morphia();
		morphia.map(Author.class).map(BlogEntry.class);

		MongoURI uri = new MongoURI("mongodb://192.168.0.76");
		Mongo mongo = new Mongo(uri);
		Datastore ds = morphia.createDatastore(mongo, "blog");

		Author author = new Author();
		author.setName("test user");

		ds.save(author);

		BlogEntry entity = new BlogEntry();
		entity.setTitle("タイトル");
		entity.setDesc("本文内容");
		entity.setAuthor(author);
		// store
		ds.save(entity);

		// retrieve
		ds.find(BlogEntry.class).field("id").equal(entity.getId());
		BlogEntry actual = ds.find(BlogEntry.class).field("id")
				.equal(entity.getId()).get();
		assertEquals("タイトル", actual.getTitle());
		assertEquals("test user", actual.getAuthor().getName());
	}

}
