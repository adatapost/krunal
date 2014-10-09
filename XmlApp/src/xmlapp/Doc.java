/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlapp;

/**
 *
 * @author admin
 */
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Doc {

    private Document doc = null;
    private Element root = null;

    public Node getRoot() { return root;}
    public Doc(String rootName) {
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            root = doc.createElement(rootName);
            doc.appendChild(root);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Node create(String elementName, String value) {
        Element ele = doc.createElement(elementName);
        if (value != null) {
            ele.appendChild(doc.createTextNode(value));
        }
        return ele;
    }
    public Node add(Node parent,Node child){
        parent.appendChild(child);
        return parent;
    }

    public void save(String fileName) {
        try {
            TransformerFactory tfactory = TransformerFactory.newInstance();
            Transformer trans = tfactory.newTransformer();

            //Create DOM Source
            DOMSource source = new DOMSource(doc);
            //Create Stream Result
            StreamResult result = new StreamResult(new File(fileName));

            //Transform the DOM
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            trans.transform(source, result);
        } catch (TransformerException ex) {
            System.out.println(ex);
        }
    }

}
