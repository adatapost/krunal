package xmlapp;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlApp {

    public static void main(String[] args) throws Exception {
        //1. Initialize the DOM Parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2. Create Document Builder object
        DocumentBuilder builder = factory.newDocumentBuilder();

        File file = new File("c:/javaprg/89/std.xml");

        Document document = builder.parse(file);

        //3. Obtain the "root" node
        Element root = document.getDocumentElement();

        //Retrive the children
        NodeList list = root.getChildNodes();
        System.out.println(list.getLength());
        for (int i = 0; i < list.getLength(); i++) {
            Node student = list.item(i);
            if (student.hasAttributes()) {
                System.out.println(((Element) student).getAttribute("className"));
            }
            if (student.getNodeType() == Node.ELEMENT_NODE) {
                //List the children of student
                NodeList list1 = student.getChildNodes();
                for (int j = 0; j < list1.getLength(); j++) {
                    Node node = list1.item(j);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(node.getNodeName() + " " + node.getTextContent());
                    }
                }
            }
        }
    }

    public static void main2(String[] args) {
        Doc x = new Doc("Emps");

        Node emp = x.create("Emp", null);
        x.add(emp, x.create("ID", "10"));
        x.add(emp, x.create("Name", "Raj"));
        x.add(x.getRoot(), emp);

        emp = x.create("Emp", null);
        x.add(emp, x.create("ID", "20"));
        x.add(emp, x.create("Name", "Manish"));
        x.add(x.getRoot(), emp);
        x.save("c:/javaprg/89/emps.xml");
    }

    public static void main1(String[] args) throws Exception {
        //1. Initialize the DOM Parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2. Create Document Builder object
        DocumentBuilder builder = factory.newDocumentBuilder();

        //3. Create New Document (org.w3c.dom.Document interface)
        Document document = builder.newDocument();

        //4. Create Root Element
        Element root = document.createElement("students");

        //5. Add child node
        Element student = document.createElement("student");
        student.setAttribute("className", "1st");
        Element roll = document.createElement("roll");
        Element name = document.createElement("name");

        roll.appendChild(document.createTextNode("10"));
        name.appendChild(document.createTextNode("Raj"));

        student.appendChild(roll);
        student.appendChild(name);
        root.appendChild(student);

        //6. Add root to the document
        document.appendChild(root);

        // 7. Transform DOM into Stream (disk file)
        TransformerFactory tfactory = TransformerFactory.newInstance();
        Transformer trans = tfactory.newTransformer();

        //Create DOM Source
        DOMSource source = new DOMSource(document);
        //Create Stream Result
        StreamResult result = new StreamResult(new File("c:/javaprg/89/std.xml"));

        //Transform the DOM
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.transform(source, result);
    }
}
