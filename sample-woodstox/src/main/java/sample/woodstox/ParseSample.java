// Copyright(c) 2006 ATL Systems, Incorporated.
//
//
package sample.woodstox;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.ctc.wstx.stax.WstxEventFactory;
import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.stax.WstxOutputFactory;

/**
 * StAX実装Woodstoxのサンプル
 * @version $Revision$
 * @author $Author$
 */
public class ParseSample {

	/**
	 * カーソル型の単純なReader
	 * @throws Exception
	 */
	public void cursorRead() throws Exception {
		XMLInputFactory factory = new WstxInputFactory();
		InputStream is = new BufferedInputStream(new FileInputStream("fruit.xml"));
		// CursorReader
		XMLStreamReader reader = factory.createXMLStreamReader(is);
		while (reader.hasNext()) {
			 reader.next();
			 if (XMLStreamConstants.START_ELEMENT == reader.getEventType()) {
    			 System.out.println(reader.getName());
    			 int cnt = reader.getAttributeCount();
    			 if (cnt != 0) {
    				 for (int i=0; i < cnt; i++) {
    					 System.out.println("AttributeName:" + reader.getAttributeLocalName(i));
    					 System.out.println("AttributeValue" + reader.getAttributeValue(i));
    				 }
    			 }
			 }
			
		}
		reader.close();

	}
	
	/**
	 * イベント型の単純なリーダー
	 * @throws Exception
	 */
	public void eventRead() throws Exception {
		XMLInputFactory factory = new WstxInputFactory();
		InputStream is = new BufferedInputStream(new FileInputStream("fruit.xml"));
		XMLEventReader reader = factory.createXMLEventReader(is);
		while (reader.hasNext()) {
			XMLEvent event =  reader.nextEvent();
			if (event.isStartElement()) {
				StartElement element = (StartElement) event;
				System.out.println(element.getName());
			}
			
		}
		reader.close();
		
	}
	
	/**
	 * イベント型リーダのフィルターを利用
	 * @throws Exception
	 */
	public void eventFilterRead() throws Exception {
		XMLInputFactory factory = new WstxInputFactory();
		InputStream is = new BufferedInputStream(new FileInputStream("fruit.xml"));
		XMLEventReader reader = factory.createXMLEventReader(is);
		EventFilter filter = new EventFilter(){
			public boolean accept(XMLEvent xmlevent) {
				return xmlevent.isStartElement();
			}};
		reader = factory.createFilteredReader(reader, filter);
		while (reader.hasNext()) {
			StartElement element = (StartElement) reader.next();
			System.out.println(element.getName());
		}
		reader.close();
		
	}
	
	/**
	 * カーソルを利用したライター
	 * @throws Exception
	 */
	public void cursorWrite() throws Exception {
		XMLOutputFactory factory = new WstxOutputFactory();
		StringWriter sw = new StringWriter();
		XMLStreamWriter writer = factory.createXMLStreamWriter(sw);
		writer.writeStartDocument();
		writer.writeDTD("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
                        + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		writer.writeStartElement("html");
		writer.writeDefaultNamespace("http://www.w3.org/1999/xhtml");
		writer.writeStartElement("body");
		writer.writeEndElement();
		writer.writeEndElement();
		writer.writeEndDocument();
		writer.close();
		System.out.println(sw.toString());
	}
	
	/**
	 * イベントを利用したライター
	 * @throws Exception
	 */
	public void eventWrite() throws Exception {
		XMLOutputFactory factory = new WstxOutputFactory();
		StringWriter sw = new StringWriter();
		XMLEventWriter writer = factory.createXMLEventWriter(sw);
		XMLEventFactory eventFactory = new WstxEventFactory();
		writer.add(eventFactory.createStartDocument("UTF-8"));
		writer.add(eventFactory.createDTD("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" "
                + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"));
		writer.add(eventFactory.createStartElement("", "http://www.w3.org/1999/xhtml", "html"));
		writer.add(eventFactory.createNamespace("http://www.w3.org/1999/xhtml"));
		writer.add(eventFactory.createStartElement("", "", "body"));
		writer.add(eventFactory.createCharacters("あいうえお"));
		writer.add(eventFactory.createEndElement("", "", "body"));
		writer.add(eventFactory.createEndElement("", "http://www.w3.org/1999/xhtml", "html"));
		writer.add(eventFactory.createEndDocument());
		System.out.println(sw.toString());
		
	}

}
