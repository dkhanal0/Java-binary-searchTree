/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bst;

public class Main {

    public static void main(String[] args) {

        XmlReader myXmlReader = new XmlReader("customers.xml");

        CustomerBst customers = myXmlReader.getCustomers();

        System.out.println("---=== In Order ===---");
        System.out.println(customers.inOrder());

        System.out.println("---=== Pre Order ===---");
        System.out.println(customers.preOrder());


        System.out.println("---=== Post Order ===---");
        System.out.println(customers.postOrder());

        // Look for a customer
        Customer myCustomer = new Customer("Morgan", "Stephen", "345 Pine St", "19144");
        Account myAccount = new CommercialAccount("234-56-788", myCustomer, "PA-2345");
        myCustomer.setAccount(myAccount);

        // Check if it is in the tree
        System.out.print("The customer ");
        if (customers.contains(myCustomer)) {
            System.out.println("was found");
        } else {
            System.out.println("was not found");
        }

        // Test removal
        customers.remove(myCustomer);
        System.out.print("After remove, the customer ");
        if (customers.contains(myCustomer)) {
            System.out.println("was found");
        } else {
            System.out.println("was not found");
        }
    }
}
