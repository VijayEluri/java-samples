package sample.google.gdata;

import java.util.List;

import junit.framework.TestCase;

import com.google.gdata.data.Entry;
import com.google.gdata.data.Feed;


public class CalendarServiceSampleTest extends TestCase {

	public void testSearchSample() throws Exception {
		CalendarServiceSample sample = new CalendarServiceSample();
		Feed feed = sample.searchSample();
		System.out.println("can post:" + feed.getCanPost());
		System.out.println("id:" + feed.getId());
		System.out.println("item per page:" + feed.getItemsPerPage());
		System.out.println("author :" + feed.getAuthors().get(0).getName());
		List list = feed.getEntries();
		for (int i=0; i < list.size(); i++) {
			Entry entry = (Entry) list.get(i);
    		System.out.println(entry.getTitle().getPlainText());
		}
	}

}
