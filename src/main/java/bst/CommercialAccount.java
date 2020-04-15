package bst;

public class CommercialAccount extends Account {

    // Copy from comparable assignment
    private String taxId;

    // Constructor
    public CommercialAccount(String accountNumber, Customer customer, String taxId) {
        // Initialize parent variables
        super(accountNumber, customer);
        // Initialize tax id
        this.taxId = taxId;
    }

    public String getTaxId() {
        return (this.taxId);
    }
}
