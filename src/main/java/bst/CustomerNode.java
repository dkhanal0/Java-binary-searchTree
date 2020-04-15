package bst;

import java.util.Random;

public class CustomerNode {

    // Use BstDemo as a guide

    //Instances variables
    Customer customer;
    CustomerNode left, right;

    //Constructor
    public CustomerNode(Customer customer){
        this.customer=customer;
        this.left=this.right=null;
    }
    //Insert: insert customer in appropriate subtree
    public void insert(Customer cust) {
        //Determine subtree location (left or right)
        if (cust.compareTo(customer) <= 0) {
            //belongs on the left side
            if (left == null) {
                //create a new left child
                left = new CustomerNode(cust);
            } else {
                left.insert(cust);
            }
        } else if (cust.compareTo(customer) >0 ){
            //belongs on the right
            if (right == null) {
                //create a new right child
                right = new CustomerNode(cust);
            } else {
                right.insert(cust);
            }

        }
    }
    //Contains: finds a value
    public boolean contains(Customer cust) {
        //check for value
        if (cust.compareTo(customer)==0) {
            return true;
        } else if (cust.compareTo(customer) < 0) {
            //could be in the left but don't have a left child
            if (left == null){
                return false;
            } else {
                return left.contains(cust);        }
        }else {
            //might be on the right
            if (right==null){
                return false;
            }else {
                return  right.contains(cust);
            }
        }

    }
    public CustomerNode remove(Customer cust){
        //check the subtrees
        if (cust.compareTo(customer)<0 ){
            //Delegate to the left child
            if (left!=null){
                left= left.remove(cust);
            }

        }else if (cust.compareTo(customer)<0){
            //Delegate to the right child
            if (right!=null){
                right=right.remove(cust);
            }
        } else {
            //I'm getting removed (means root is getting removed)
            if (left==null && right==null){
                //case 1: left node
                return null;
            }else if (left!= null && right==null){
                //case 2-- node with only left
                return left;
            }else if (left==null && right!= null){
                //case 2: node with only right
                return right;
            }else {
                //case 3: two children so import random to generate left or right value
                Random r= new Random();//Random value generator

                //(1) Identify a new value, then (2) remove the duplicate

                if (r.nextBoolean()){
                    //get maximum value from left
                    customer= left.rightMost(); //If it is in the left, need to find the biggest value in the left
                    //remove duplicate from the left
                    left=left.remove(customer);
                } else {
                    //get minimum from the right
                    customer= right.leftMost(); //need to find the smallest valie from the right subtree
                    //remove duplicate from the right
                    right= right.remove(customer);
                }
            }
        }
        // Return self reference
        return this;
    }

    protected Customer rightMost() {
        //returns the right most customer
        if (right==null){
            //no more right children
            return customer;
        }else {
            return right.rightMost();
        }

    }

    protected Customer leftMost() {
        //returns the left most customer]
        if (left==null){
            //no more left children
            return customer;
        }else {
            return left.leftMost();
        }
    }
    //Traversals
    public String inOrder(){
        String treeStr= ""  ;

        //Go left
        if (left!= null){
            treeStr= treeStr + left.inOrder();
        }
        //visit the node
        treeStr= treeStr + "[" + customer.getLastName() + ":" + customer.getFirstName() + ":" + customer.getAccount().getAccountNumber() + "]" ;

        //Go right
        if (right!= null){
            treeStr= treeStr + right.inOrder();
        }
        //return String
        return treeStr;
    }
    public String preOrder(){
        String treeStr= "";
        //visit the node
        treeStr= treeStr + "[" + customer.getLastName() + ":" + customer.getFirstName() + ":" + customer.getAccount().getAccountNumber() + "]" ;

        //Go left
        if (left!=null){
            treeStr= treeStr + left.preOrder();

        } //Go right
             if(right != null) {
                 treeStr = treeStr + right.preOrder();
             }
            return treeStr ;
    }
    public String postOrder(){
        String treeStr= "" ;
        //Go left
        if (left!= null){
           treeStr= treeStr + left.postOrder();
        }
        //go to right
         if (right!=null ) {
             treeStr = treeStr + right.postOrder();
         }
            treeStr= treeStr + "[" + customer.getLastName() + ":" + customer.getFirstName() + ":" + customer.getAccount().getAccountNumber() + "]" ;

        return treeStr ;
    }

}















