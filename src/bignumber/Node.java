package bignumber;

public class Node {
    // value stored in the node
    private int val;
    // a pointer pointing to the next node
    private Node next;

    public Node(int val) {
        this.val = val;
        // init next to point to null
        this.next = null;
    }

    // overloading constructor for Node so that we can
    // construct a linked list manually
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return this.val;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setVal(int val){ this.val = val; }


}
