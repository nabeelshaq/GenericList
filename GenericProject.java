// Nabeel Haq - nhaq2
// nhaq2@uic.edu
// Project 1 - Generic Lists in Java
// This program uses a generic version of the stack and queue
// data structures in a linked list.

package genericproject;

public class GenericProject {
    public static void main(String[] args) {
        /*
        GenericQueue<Integer> myQ = new GenericQueue<>(9);
        myQ.enqueue(7);
        myQ.enqueue(7);
        myQ.print();
        myQ.printLength();
        
        GenericStack<Integer> myS = new GenericStack<>(9);
        myS.printLength();
        myS.push(8);
        myS.print();
        myS.printLength();
        myS.pop();
        myS.print();
        myS.printLength();
        */
    }  
}

abstract class GenericList<I>{
    Node<I> head;
    private int length;
    
    public class Node<I>{
        I data;
        Node<I> next;
        Node(){} // default constructor for Node class 
        Node(I data){  // constructor 
            this.data = data;  // to allow for simpler new node
            this.next = null;  // and set the next to null
        }
    }
    GenericList(){}  // default constructor for GenericList
  
    GenericList (I data){  // constructor to set given to to head.data
    	head = new Node(data);
    }
    
    public void setLength(int length){ // setter for length
        this.length = length;
    }
    public int getLength(){ // getter for length to keep track of it
        return this.length;
    }
    public void printLength(){ // prints out the length
        System.out.println(this.length);
    }
   
    public void print() {  // prints out every item in the list
        Node temp = new Node(null);  // temporary node to traverse the list
        temp = head;
	while(temp != null){ // traverse
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    
    public abstract void add (I data); //adds the value to the list.
    
    public Object delete() { //returns the first value of the list and deletes the node.
        if (head == null){  // if first value is null, list is empty so return
            return null;
        }
        length--; // decrement length of list since we're deleting
        Node temp = new Node(null);  // temporary node 
        temp = head;                    // to set head
        head = head.next;               // to head.next
        return temp.data;              
    }

}

 class GenericQueue<I> extends GenericList<I>{

    GenericQueue(){}  // default constructor
    
    GenericQueue(I data) {  // constructor to allow for test cases with primitive data types
        head=new Node(data);  // set head to the given data
        setLength(getLength()+1);  // increment length counter
    }
   
    @Override
    public void add (I data){ // add value to end of list
        Node temp = new Node();  //temporary node with new data
        temp.data = data;
        Node trav = head;
        if (head == null){  // if empty list, set head to temporary one
            head = temp;
        }
        else{
            while(trav.next!=null){  // traverse to end of list
                trav = trav.next;
            }
            trav.next = temp;   // set end of list to temporary node
        }
        setLength(getLength()+1);  // increment length counter
    }
    public void enqueue (I data){ // calls add function
        add(data);
    }
    public void dequeue(){ // call delete to return/delete first value
        delete();
    }

}

 class GenericStack<I> extends GenericList{

    GenericStack(){} // default constructor
      
    GenericStack(I data) {  // constructor allow for test cases with primitive data types
        head = new Node(data);  // set head to given data
        setLength(getLength()+1); // increment length counter
    }
    
    @Override
    public void add (Object data){ // add value to front of list
        Node temp = new Node(data);  //temporary node with given data
        temp.next = head;  // set next to head since adding to front
        head = temp;  // set head to new node 
        setLength(getLength()+1);  // increment length counter
    }
    public void push (I data){ // calls add function
        add(data);
    }
    public void pop(){  // pop from the top of the stack, call delete
        delete();
    }
    
}
