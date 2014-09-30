// Copyright(c) 2007 ATL Systems, Incorporated.
//
//
package ibatis.test.lab.builder.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.ibatis.sqlmap.engine.builder.xml.SqlMapClasspathEntityResolver;
import com.ibatis.sqlmap.engine.builder.xml.XmlConverter;

public class SqlMapXmlConverterImpl implements XmlConverter {

    public Reader convertXml(Reader reader) {
        // TODO Auto-generated method stub
        return null;
    }

    public void convertXml(Reader reader, Writer writer) {
        // TODO Auto-generated method stub

    }

    public InputStream convertXml(InputStream inputStream) {
        // FIXME とりあえず、ここを実装するべし
        // それぞれのSqlMap.xmlが呼ばれたときに
        // <sqlMap namespace="Guitar">のnamespaceからEntityを判別してDOM操作して
        // それぞれの<resultMap id="Guitar">をつくって自動的に入れてやる。

        Document document;
        try {
            document = createDocument(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Element resultMapEle = document.createElement("resultMap");
        resultMapEle.setAttribute("id", "Guitar");
        resultMapEle.setAttribute("class", "ibatis.test.bean.Guitar");

        Element resultEle = document.createElement("result");
        resultEle.setAttribute("property", "id");
        resultEle.setAttribute("column", "ID");
        resultEle.setAttribute("columnIndex", "1");
        resultMapEle.appendChild(resultEle);

        resultEle = document.createElement("result");
        resultEle.setAttribute("property", "name");
        resultEle.setAttribute("column", "NAME");
        resultEle.setAttribute("columnIndex", "2");
        resultMapEle.appendChild(resultEle);

        resultEle = document.createElement("result");
        resultEle.setAttribute("property", "maker");
        resultEle.setAttribute("column", "MAKER");
        resultEle.setAttribute("columnIndex", "3");
        resultMapEle.appendChild(resultEle);
        
        // 上記のDOMツリー作るツールがいるなぁ。
        appendCreateNode(document, resultMapEle);

        try {

            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
                    "http://ibatis.apache.org/dtd/sql-map-2.dtd");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,
                    "ibatis.apache.org//DTD SQL Map 2.0//EN");
            DOMSource source = new DOMSource(document);

            // PipedInputStream io = new PipedInputStream();
            // StreamResult result = new StreamResult(new
            // PipedOutputStream(io));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(os);
            transformer.transform(source, result);
            System.out.println(new String(os.toByteArray()));

            return new ByteArrayInputStream(os.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a JAXP Document from an InoutStream.
     */
    private Document createDocument(InputStream inputStream) throws ParserConfigurationException,
            FactoryConfigurationError, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        factory.setNamespaceAware(true);
        factory.setIgnoringComments(true);
        factory.setIgnoringElementContentWhitespace(false);
        factory.setCoalescing(false);
        factory.setExpandEntityReferences(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new SqlMapClasspathEntityResolver());
        builder.setErrorHandler(new ErrorHandler() {
            public void error(SAXParseException exception) throws SAXException {
                throw exception;
            }

            public void fatalError(SAXParseException exception) throws SAXException {
                throw exception;
            }

            public void warning(SAXParseException exception) throws SAXException {
            }
        });

        return builder.parse(new InputSource(inputStream));
    }

    /**
     * 特定の場所にノードを追加する
     * @param document
     * @param node
     */
    private void appendCreateNode(Document document, Node paramNode) {
        NodeList nodeList = document.getElementsByTagNameNS("*", "*");
        if (nodeList.getLength() == 0) {
            document.insertBefore(document, paramNode);
            return;
        }
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("node name:" + node.getNodeName());
            if (!node.getNodeName().equals("sqlMap") && !node.getNodeName().equals("typeAlias") && !node.getNodeName().equals("cacheModel")) {
                node.getParentNode().insertBefore(paramNode, node );
                return;
                
            }
        }
    }

}
