package bst;

public class CustomerBst {

    // Use BstDemo as a guide

    //Instances variable
    CustomerNode root;

    //Constructor
    public CustomerBst(){
        this.root=root;
    }
    //insert - insert a new value

    public void insert( Customer cust){
        if (root==null){
            //If the root is empty, this will be the first node
            root=new CustomerNode(cust);
        }else   {
            root.insert(cust);
        }
    }
    //contains- look for a value
    public boolean contains(Customer cust){
        if (root== null) {
            return false;
        }else {
            return root.contains(cust);
        }
    }

    //Remove -- remove a value
    public void remove( Customer customer){
        if (root!= null){
            root=root.remove(customer);
        }
    }
    public String inOrder(){
        if (root != null){
            return root.inOrder();
        }else {
            return "";
        }
    }
    public String preOrder(){
        if (root!=null){
            return root.preOrder();
        }else {
            return "";
        }
    }
    public String postOrder(){
        if (root!=null){
            return root.postOrder();
        }else {
            return postOrder();
        }
    }

}
