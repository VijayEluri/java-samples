// Copyright(c) 2007 ATL Systems, Incorporated.
//
//
package sample.dom.manipulate;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 直にDOMを操作するサンプル
 * これつくるって読み込む
 *<?xml version="1.0" encoding="UTF-8"?>
 * <profile id="M-IO-000000" date="20000101">
 *  <name>
 *    <firstname>Takashi</firstname>
 *    <surname>Funato</surname>
 *  </name>
 *  <gender>male</gender>
 *  <job>Engineer</job>
 *</profile>
 */
public class SampleDomManupMain {

    public static void main(String[] args) throws Exception {
        SampleDomManupMain obj = new SampleDomManupMain();
        obj.create(); // なにもないところから新しくDOM作って書き出してみるよ
        obj.read(); // createで作ったXMLを読み込んでみるよ
    }

    /**
     * 新しくDOMを作ってみるよ
     */
    public void create() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 検証を行うつもりなら、インスタンスを生成する前に以下のようなコードを挿入します。
        // factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element profileEle = doc.createElement("profile");
        profileEle.setAttribute("id", "M-IO-000000");
        profileEle.setAttribute("date", "20000101");
        doc.appendChild(profileEle);
        
        Element nameEle = doc.createElement("name");
        Element firstnameEle = doc.createElement("firstname");
        firstnameEle.setTextContent("Takashi");
        nameEle.appendChild(firstnameEle);
        
        Element surnameEle = doc.createElement("surname");
        surnameEle.setTextContent("Funato");
        nameEle.appendChild(surnameEle);
        
        profileEle.appendChild(nameEle);
        
        
        Element genderEle = doc.createElement("gender");
        genderEle.setTextContent("male");
        profileEle.appendChild(genderEle);

        Element jobEle = doc.createElement("job");
        jobEle.setTextContent("Engineer");
        profileEle.appendChild(jobEle);
        
        // System.outに書き出してみる
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        File newXML = new File("foo.xml");  // ファイルに書き出してみる
        FileOutputStream os = new FileOutputStream(newXML); 
        StreamResult result = new StreamResult(os); 
        transformer.transform(source, result);
        // XXX 面倒くさ

    }

    /**
     * XMLを読み込んでDOMにしてSystem.outに表示してみるよ
     */
    public void read() throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("foo.xml"));

        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        Result result = new StreamResult(System.out);
        transformer.transform(source, result);
    }

}
