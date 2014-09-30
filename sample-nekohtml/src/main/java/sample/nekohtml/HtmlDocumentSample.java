package sample.nekohtml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.DocumentType;
import org.w3c.dom.html.HTMLDocument;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class HtmlDocumentSample {

	public void render() {
		String inputFile = "input.html";
		DOMParser parser = new DOMParser();
		HTMLDocument document;
		try {
			parser.setFeature("http://xml.org/sax/features/namespaces", false);
			InputStream inputStream = new FileInputStream(new File(inputFile));
			InputSource inputSource = new InputSource(inputStream);
			inputSource.setEncoding("UTF-8");
			parser.parse(inputSource);
			document = (HTMLDocument)parser.getDocument();

			Source source = new DOMSource(document);
			Properties props = new Properties();
		    props.setProperty("method", "html");	
		    props.setProperty("omit-xml-declaration", "yes");	
		    props.setProperty("indent", "no");	
		    props.setProperty("{http://xml.apache.org/xalan}use-url-escaping", "no");	

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			System.out.println(transformer.getClass());
		    transformer.setOutputProperties(props);
			DocumentType docType = document.getDoctype();
			if (docType != null) {
				if (docType.getPublicId() != null) {
					transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, docType.getPublicId());
				}
				if (docType.getSystemId() != null) {
					transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, docType.getSystemId());
				}
			}
			Result result = new StreamResult(System.out);
			transformer.transform(source, result);

		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
