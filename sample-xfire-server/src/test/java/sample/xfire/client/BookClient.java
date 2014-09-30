// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.xfire.client;

import java.net.MalformedURLException;
import java.util.Map;

import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import sample.xfire.dto.Book;
import sample.xfire.handler.OutHeaderHandler;
import sample.xfire.service.BookService;

public class BookClient {
        public static void main(String args[])
        {
            String serviceURL = "http://localhost:8080/xfire-sample/services/BookService";
            Service serviceModel = new ObjectServiceFactory().create(BookService.class,null,"http://xfire.codehaus.org/BookService",null);
            
            XFireProxyFactory serviceFactory = new XFireProxyFactory();
            
            try
            {
                BookService service = (BookService) serviceFactory.create(serviceModel, serviceURL);
                Client client = Client.getInstance(service);
                client.addOutHandler(new OutHeaderHandler());
                Book[] books = service.getBooks();
                Map booksMap = service.getBooksMap();
                System.out.print("Received map with "+booksMap.size()+" book(s) \n");
                System.out.println("BOOKS:");
                
                for (int i = 0; i < books.length; i++)
                {
                    System.out.println(books[i].getTitle());
                }
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
        }
}
