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
 * ����DOM�𑀍삷��T���v��
 * ���������ēǂݍ���
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
        obj.create(); // �Ȃɂ��Ȃ��Ƃ��납��V����DOM����ď����o���Ă݂��
        obj.read(); // create�ō����XML��ǂݍ���ł݂��
    }

    /**
     * �V����DOM������Ă݂��
     */
    public void create() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // ���؂��s������Ȃ�A�C���X�^���X�𐶐�����O�Ɉȉ��̂悤�ȃR�[�h��}�����܂��B
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
        
        // System.out�ɏ����o���Ă݂�
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        File newXML = new File("foo.xml");  // �t�@�C���ɏ����o���Ă݂�
        FileOutputStream os = new FileOutputStream(newXML); 
        StreamResult result = new StreamResult(os); 
        transformer.transform(source, result);
        // XXX �ʓ|����

    }

    /**
     * XML��ǂݍ����DOM�ɂ���System.out�ɕ\�����Ă݂��
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
