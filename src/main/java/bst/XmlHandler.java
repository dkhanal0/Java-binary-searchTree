package bst;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;

public class XmlHandler extends DefaultHandler {

    private CustomerBst customers = new CustomerBst();  // ArrayList of all Customers
    private Customer currentCustomer; // Reference to the current Customer being processed
    private Account currentAccount; // Reference to the current Account being processed

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        // System.out.println("Start element:" + qName);
        // Handle the customer element
        if (qName.equals("customer")) {
            // Get attribute values
            String lastName = attributes.getValue("lastName");
            String firstName = attributes.getValue("firstName");
            String streetAddress = attributes.getValue("streetAddress");
            String zipCode = attributes.getValue("zipCode");

            // Instantiate the currentCustomer
            currentCustomer = new Customer(lastName, firstName, streetAddress, zipCode);
        }
        // Handle account element
        if  (qName.equals("account")) {
            // Get attribute values
            String type = attributes.getValue("commercial");
            String taxId = attributes.getValue("taxId");
            String accountNumber = attributes.getValue("accountNumber");

            // Determine account type and instantiate currentAccount
            if (attributes.getValue("commercial") !=null && type.contentEquals("true")) {
                currentAccount = new CommercialAccount(accountNumber, currentCustomer, taxId);
            } else {
                currentAccount = new NonCommercialAccount(accountNumber, currentCustomer);
            }
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("End element:" + qName);

        // Handle customer element
        if (qName.equals("customer")) {
            // Add currentCustomer to list of customers
            customers.insert(currentCustomer);
        }
        // Handle account element
        if (qName.equals("account")) {

            // Associate currentAccount with currentCustomer
            currentCustomer.setAccount(currentAccount);
        }
    }
    public CustomerBst getCustomers(){
        return customers;
    }
}



