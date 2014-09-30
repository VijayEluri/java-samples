/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package com.a2suite.rss.sample;

import java.io.File;

import churchillobjects.rss4j.RssChannel;
import churchillobjects.rss4j.RssChannelImage;
import churchillobjects.rss4j.RssChannelItem;
import churchillobjects.rss4j.RssDocument;
import churchillobjects.rss4j.generator.RssGenerationException;
import churchillobjects.rss4j.generator.RssGenerator;

/**
 * 
 * @author funato
 * @createted 2005/04/14
 */
public class RssWriterMain {

    public static void main(String[] args) {
        RssDocument doc = new RssDocument();
        doc.setVersion(RssDocument.VERSION_10);

//         create and add a new channel
        RssChannel channel = new RssChannel();
        channel.setChannelTitle("ChurchillObjects.com Features");
        channel.setChannelLink("http://www.churchillobjects.com");
        channel.setChannelDescription("Advanced Object-Oriented Developer Resource");
        channel.setChannelUri("http://www.churchillobjects.com/rss/");
        doc.addChannel(channel);

//         create and add two items

        RssChannelItem item1 = new RssChannelItem();
        item1.setItemTitle("Networking Apps With Redenzvous");
        item1.setItemLink("http://www.churchillobjects.com/c/11028.html");
        item1.setItemDescription("Avoid the difficulties of internetworked applications with this fast, robust framework package.");
        channel.addItem(item1);

        RssChannelItem item2 = new RssChannelItem();
        item2.setItemTitle("Secure Sockets with JSSE & OpenSSL");
        item2.setItemLink("http://www.churchillobjects.com/c/11201.html");
        item2.setItemDescription("Find out how to implement robust secure communnications between your clients and servers, including making your own certificate authority.");
        channel.addItem(item2);

//         create and add an image for the channel
        RssChannelImage img = new RssChannelImage();
        img.setImageLink("http://www.churchillobjects.com");
        img.setImageUrl("http://www.churchillobjects.com/i/co.gif");
        img.setImageTitle("ChurchillObjects.com");
        channel.setChannelImage(img);
        
        File file = new File("rss.xml");
        try{
          RssGenerator.generateRss(doc, file);
          System.out.println("RSS file written.");
        }
        catch(RssGenerationException e){
          e.printStackTrace();
        }
    }
}
