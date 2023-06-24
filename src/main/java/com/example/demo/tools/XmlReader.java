package com.example.demo.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 9:00 AM
 **/
public class XmlReader {

    private final static XmlReader XML_READER = new XmlReader();

    public static XmlReader getInstance() {
        return XML_READER;
    }

    /**
     * this method returns the servletName and list of roles that assigned to it.
     **/
    public Map<String, List<String>> readXml(String element, List<String> nodes) {
        Map<String, List<String>> map = new HashMap<>();
        try {
            //creating a constructor of file class and parsing an XML file
            File file = new File("C:\\Root\\Project\\demo\\src\\main\\resources\\roles.xml");
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName(element);
            // nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String servletName = eElement.getElementsByTagName(nodes.get(0)).item(0).getTextContent();
                    System.out.println("servlet name: " + servletName);
                    String roles = eElement.getElementsByTagName(nodes.get(1)).item(0).getTextContent();
                    System.out.println("roles: " + roles);
                    map.put(servletName, Arrays.asList(roles));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
