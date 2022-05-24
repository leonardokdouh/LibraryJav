package com.solvd.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOG = LogManager.getLogger(DomParser.class);

    public void ordersXML(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/orders.xml");
            NodeList ordersList = doc.getElementsByTagName("order");
            for (int i = 0; i < ordersList.getLength(); i++) {
                Node p = ordersList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    Element order = (Element) p;
                    String id = order.getAttribute("id");
                    NodeList tables = order.getChildNodes();
                    for (int j = 0; j < tables.getLength(); j++) {
                        Node n = tables.item(j);
                        if (n.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) n;

                            LOG.info("Order " + id + ":" +
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

