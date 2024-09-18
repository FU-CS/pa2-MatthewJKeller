package pa2;

/**
 * A sorted singly linked list of integers
 */
public class LinkedList {

    /**
     * A node in the linked list
     */
    public Node head;

    /**
     * Constructor
     * Initialize the linked list with a null head
     */
    public LinkedList() {
        this.head = null;
    }
    
    /** 
     * Add a new node to the linked list 
     * so that the list remains sorted
     * @param value The value to add
     * @return void
     */
    public void add(int value) {
        Node newNode = new Node(value);
        Node current = this.head;
        if (this.head == null) {
            this.head = newNode;
        } else if (this.head.value >= value) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            while (current.next != null && current.next.value < value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /**
     * Remove the first node with the given value
     * If the value is not found, do nothing
     * @param value The value to remove
     * @return void
     */
    public void remove(int value) {
        if (this.head == null) {
            return;
        }

        if (this.head.value == value) {
            this.head = this.head.next;
            return;
        }
    
        Node current = this.head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }
    
        if (current.next != null && current.next.value == value) {
            current.next = current.next.next;
        }
    }
    

    /**
     * Traverse the linked list RECURSIVELY and returns a string representation of the list
     * @param current
     * @return String
     */

    private String traverse(Node current){
        if (current == null) {
            return "";
        }
        else{
            return current.value + " " + traverse(current.next);
        }
    }

    /**
     * Traverse the linked list and returns a string representation of the list
     * @return String
     */
    public String traverse(){
        String concat = "";
        Node current = this.head;
        while (current != null){
            concat = concat + current.value + " ";
            current = current.next;
        }
        return concat;
    }

    /**
     * Traverse the linked list RECURSIVELY and 
     * returns the reverse string representation of the list
     * e.g. the linked list 1 -> 2 -> 3 -> 4 will be printed as 4 3 2 1
     * @return String
     */
    public String reverse() {
        return reverseHelper(this.head);
    }
    
    private String reverseHelper(Node current) {
        if (current == null) {
            return "";
        }
        String result = reverseHelper(current.next);
        if (result.isEmpty()) {
            return current.value + "";
        } 
        else {
            return result + " " + current.value;
        }
    }
    

    /**
     * Merges two sorted linked list and returns the 
     * merged linked list that is also sorted
     * @param list1 The first sorted linked list
     * @param list2 The second sorted linked list 
     * @return LinkedLists
     */
    
    public static LinkedList merge(LinkedList list1, LinkedList list2){
            LinkedList concatList = new LinkedList();
            
            if(list1.head == null){
                return list2;
            }
            if(list2.head == null){
                return list1;
            }
            Node curr1 = list1.head;
            Node curr2 = list2.head;
            Node finalNode = null;

            while (curr1 != null && curr2 != null) {
                if (curr1.value <= curr2.value) {
                    if (finalNode == null) {
                        concatList.head = curr1;
                    } 
                    else {
                        finalNode.next = curr1;
                    }
                    finalNode = curr1;
                    curr1 = curr1.next;
                } 
                else {
                    if (finalNode == null) {
                        concatList.head = curr2;
                    } else {
                        finalNode.next = curr2;
                    }
                    finalNode = curr2;
                    curr2 = curr2.next;
                }
            }
            if (curr1 != null) {
                finalNode.next = curr1;
            } 
            else if (curr2 != null) {
                finalNode.next = curr2;
            }
            return concatList;
        }
        

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.traverse());
        list.remove(3);
        System.out.println(list.traverse());
    }
}