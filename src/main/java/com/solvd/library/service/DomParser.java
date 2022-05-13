package com.solvd.library.service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse("src/main/resources/orders.xml");
                NodeList personList = doc.getElementsByTagName("order");
                for (int i = 0; i < personList.getLength(); i++) {
                    Node p = personList.item(i);
                    if (p.getNodeType() == Node.ELEMENT_NODE) {
                        Element order = (Element) p;
                        String id = order.getAttribute("id");
                        NodeList notes = order.getChildNodes();
                        for (int j = 0; j < notes.getLength(); j++) {
                            Node n = notes.item(j);
                            if (n.getNodeType() == Node.ELEMENT_NODE) {
                                Element name = (Element) n;

                                System.out.println("Order " + id + ":" +
                                        name.getTagName() + "=" + name.getTextContent());
                            }
                        }
                    }
                }
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
        }
    }

