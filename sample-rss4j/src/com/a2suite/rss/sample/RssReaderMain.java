/*
 * çÏê¨ì˙: 2005/02/02
 */
package com.a2suite.rss.sample;

import churchillobjects.rss4j.RssChannel;
import churchillobjects.rss4j.RssChannelItem;
import churchillobjects.rss4j.RssDocument;

import churchillobjects.rss4j.parser.RssParser;

import java.net.URL;

import java.util.Enumeration;


/**
 * @author funato
 */
public class RssReaderMain {
    public static void main(String[] args) throws Exception {
        URL objUrl = new URL("http://eng.atlsys.com/pukiwiki/pukiwiki.php?cmd=rss");
        RssDocument objDoc =
            RssParser.parseRss(objUrl.openConnection().getInputStream());
        Enumeration objEnm = objDoc.channels();

        while (objEnm.hasMoreElements()) {
            RssChannel objRc = (RssChannel)objEnm.nextElement();
            Enumeration items = objRc.items();
            System.out.println("Title:" + objRc.getChannelTitle());

            while (items.hasMoreElements()) {
                RssChannelItem item = (RssChannelItem)items.nextElement();
                System.out.println(item.getItemLink());
                System.out.println(item.getItemTitle());
                System.out.println(item.getItemDescription());
            }
        }
    }
}
