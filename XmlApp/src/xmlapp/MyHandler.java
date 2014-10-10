/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlapp;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author admin
 */
public class MyHandler extends DefaultHandler {

    private List<Student> list = new ArrayList<Student>();
    private Student std;
    private String data;

    @Override
    public void characters(char[] array, int start, int length) throws SAXException {
        data = new String(array, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("roll")) {
            std.setRoll(data);
        }
        if (qName.equals("name")) {
            std.setName(data);
        }
        if (qName.equals("student")) {
            list.add(std);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("student")) {
            std = new Student();
            std.setClassName(attributes.getValue("className"));
        }
    }

    public List<Student> getList() {
        return list;
    }
}
