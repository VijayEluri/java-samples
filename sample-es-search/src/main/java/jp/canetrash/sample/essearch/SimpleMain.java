package jp.canetrash.sample.essearch;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class SimpleMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		Client client = new TransportClient()
				.addTransportAddress(new InetSocketTransportAddress(
						"192.168.0.1", 9300));
		SearchResponse response = client.prepareSearch("plexts")
				.setTypes("all").execute().actionGet();
		System.out.println(response.getHits().getTotalHits());
	}

}
