package com.solvd.library.services.jaxBParser;

import com.solvd.library.bin.LendsDetail;
import com.solvd.library.bin.OrdersDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxB {

    private static final Logger LOGGER = LogManager.getLogger(JaxB.class);

    public OrdersDetails unmarshall(String path) {
        File newF = new File(path);
        JAXBContext jaxB;
        try {
            jaxB = JAXBContext.newInstance(OrdersDetails.class);
            Unmarshaller unmarshaller = jaxB.createUnmarshaller();
            return (OrdersDetails) unmarshaller.unmarshal(newF);
        } catch (JAXBException e) {
            LOGGER.error("Unable to parse the file", e);
            throw new RuntimeException(e);
        }
    }

    public void marshall(LendsDetail lends, String path) {
        JAXBContext jaxB;
        try {
            jaxB = JAXBContext.newInstance(OrdersDetails.class);
            Marshaller marshaller = jaxB.createMarshaller();
            marshaller.marshal(lends, new File(path));
        } catch (JAXBException e) {
            LOGGER.error("Unable to create the objetct", e);
        }
    }

}
