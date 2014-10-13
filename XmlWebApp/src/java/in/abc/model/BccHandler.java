/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.abc.model;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author admin
 */
public class BccHandler extends DefaultHandler {

    List<BccNews> list = new ArrayList<>();
    BccNews news = null;
    boolean isItem = false;
    String data;

    public List<BccNews> getList() {
        return list;
    }

    @Override
    public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
        data = new String(arg0, arg1, arg2);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (isItem) {
            if (qName.equals("title")) {
                news.setTitle(data);
            }
            if (qName.equals("description")) {
                news.setDescription(data);
            }
            if (qName.equals("pubDate")) {
                news.setPubDate(data);
            }
            if (qName.equals("link")) {
                news.setLink(data);
            }

            if (qName.equals("item")) {
                list.add(news);
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("item")) {
            news = new BccNews();
            isItem = true;
        }

    }

}
