package jp.canetrash.sample.morphia;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Morphia morphia = new Morphia();
		morphia.map(Hotel.class).map(Address.class);

		MongoURI uri = new MongoURI("mongodb://192.168.0.76");
		Mongo mongo = new Mongo(uri);
		Datastore ds = morphia.createDatastore(mongo, "morphia");

		// store
		Hotel hotel = new Hotel();
		hotel.setName("My Hotel");
		hotel.setStars(4);
		hotel.setDate(new Date());

		Address address = new Address();
		address.setStreet("123 Some street");
		address.setCity("Some city");
		address.setPostCode("123 456");
		address.setCountry("Some country");

		hotel.setAddress(address);
		ds.save(hotel);

		// retrieve
		hotel = ds.get(Hotel.class, new ObjectId("4d539bea52e1a301d9fd577b"));
		System.out.println(hotel.getName());
		System.out.println(hotel.getAddress().getCity());
		System.out.println(hotel.getDate());

		// list retrieve
		List<Hotel> fourStarHotels = ds.find(Hotel.class, "stars >=", 4)
				.asList();
		System.out.println(fourStarHotels.size());
		for (Hotel obj : fourStarHotels) {
			System.out.println(obj.getName());
		}
	}

}
