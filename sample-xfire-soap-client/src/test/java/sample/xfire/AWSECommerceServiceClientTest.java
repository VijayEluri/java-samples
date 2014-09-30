package sample.xfire;

import junit.framework.TestCase;

import com.amazon.webservices.awseCommerceService.x20060628.ItemSearchDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ItemSearchRequest;
import com.amazon.webservices.awseCommerceService.x20060628.ItemSearchResponseDocument;
import com.amazon.webservices.awseCommerceService.x20060628.ItemSearchDocument.ItemSearch;
import com.amazon.webservices.awseCommerceService.x20060628.ItemSearchResponseDocument.ItemSearchResponse;
import com.amazon.webservices.awseCommerceService.x20060628.ItemsDocument.Items;

public class AWSECommerceServiceClientTest extends TestCase {

	public void testGetAWSECommerceServicePort() throws Exception {
		AWSECommerceServiceClient client = new AWSECommerceServiceClient();
		AWSECommerceServicePortType port = client.getAWSECommerceServicePort();

		ItemSearchDocument document = ItemSearchDocument.Factory.newInstance();
		ItemSearch search = document.addNewItemSearch();
		
		search.setAWSAccessKeyId("0BV3V8M5J5KMAAY9JFG2");
		search.setAssociateTag("inventionwork-22");
		ItemSearchRequest request = search.addNewRequest();
		request.setAuthor("ÉçÅ[ÉäÉìÉO");
		request.setSearchIndex("Books");
		
		ItemSearchResponseDocument responseDoc = port.itemSearch(document);
		ItemSearchResponse response = responseDoc.getItemSearchResponse();
		Items[] items = response.getItemsArray();
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
	}

}
