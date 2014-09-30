package sample.google.gdata;

import java.net.URL;

import com.google.gdata.client.calendar.CalendarQuery;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.Feed;

/**
 * GoogleCalendarのAPIのサンプル
 * http://code.google.com/apis/gdata/calendar.html
 * @author funato
 *
 */
public class CalendarServiceSample {

	/**
	 * 公開された特定のカレンダーの情報を取得する
	 * @return
	 * @throws Exception
	 */
	public Feed searchSample() throws Exception {
		URL feedUrl = new URL("http://www.google.com/calendar/feeds/tfunato@gmail.com/private-7684b624d1956bf30df433a0b4a88db4/basic");
		CalendarQuery query = new CalendarQuery(feedUrl);
		query.setMinimumStartTime(DateTime.parseDateTime("2006-03-16T00:00:00"));
		query.setMaximumStartTime(DateTime.parseDateTime("2006-11-24T23:59:59"));
		query.setFullTextQuery("");
		System.out.println(query.getUrl());

		CalendarService myService = new CalendarService("exampleCo-exampleApp-1");

		Feed resultFeed = myService.query(query, Feed.class);
		return resultFeed;
	}
}
