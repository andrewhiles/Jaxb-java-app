package jaxb;

import generated.CustomerType;
import generated.OrderType;
import generated.Root;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by andrewhiles on 19/06/2016.
 */
public class Application {

    public static void main(String[] args) throws JAXBException,
            FileNotFoundException {
        JAXBContext context = JAXBContext
                .newInstance(generated.ObjectFactory.class.getPackage().getName(),
                        generated.ObjectFactory.class.getClassLoader());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Root root = (Root) unmarshaller.unmarshal(new FileInputStream(
                "src/main/resources/sampleXml/sampleOrders.xml"));

        System.out.println("** Customers **");
        System.out.println("====================");
        for (CustomerType currentCustomer : root.getCustomers().getCustomer()) {
            System.out.println(currentCustomer.getCompanyName());
            System.out.println(currentCustomer.getContactName());
            System.out.println(currentCustomer.getContactTitle());
            System.out.println(currentCustomer.getCustomerID());
            System.out.println(currentCustomer.getFullAddress());
            System.out.println(currentCustomer.getPhone());
            System.out.println("-----");
        }
        System.out.println("** Orders **");
        System.out.println("====================");
        for (OrderType currentOrder : root.getOrders().getOrder()) {
            System.out.println(currentOrder.getCustomerID());
            System.out.println(currentOrder.getEmployeeID());
            System.out.println(currentOrder.getOrderDate());
            System.out.println(currentOrder.getShipInfo().getShipAddress());
            System.out.println(currentOrder.getShipInfo().getShipName());
            System.out.println(currentOrder.getShipInfo().getShipName());
            System.out.println("-----");
        }
    }
}
