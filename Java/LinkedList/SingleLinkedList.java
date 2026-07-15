package LinkedList;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public static Node createNode(int data) {
        return new Node(data);
    }

    public static void insertNodeAtBegining(int data) {
        Node newNode = createNode(data);
        newNode.next = SingleLinkedList.head;
        SingleLinkedList.head = newNode;
    }

    public static void insertNodeAtPosition(int data, int pos) {
        Node newNode = createNode(data);
        if (pos == 1) {
            insertNodeAtBegining(data);
            return;
        }
        int count = 1;
        Node temp = SingleLinkedList.head;
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Cant insert Node at Position " + pos);
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
            return;
        }
    }

    public static int deleteFirstNode() {
        if (SingleLinkedList.head==null) {
            System.out.println("LinkedList is Empty");
            return -1;
        }
        int data = SingleLinkedList.head.data;
        SingleLinkedList.head = SingleLinkedList.head.next;
        return data;
    }

    public static void displayLinkedList() {
        if (SingleLinkedList.head==null) {
            System.out.println("LinkedList is Empty");
            return ;
        }
        Node temp = SingleLinkedList.head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static int postionOfNodeWithData(int data){
        int pos =0;
        Node temp = SingleLinkedList.head;
        while (temp!=null) {
            pos++;
            if (temp.data==data) {
                return pos;
            }
            temp=temp.next;
        }
        return pos;
    }

}

public class SingleLinkedList {
    static Node head = null;

    public static void main(String[] args) {

        Node.insertNodeAtBegining(5);
        Node.insertNodeAtBegining(14);
        Node.insertNodeAtBegining(45);
        Node.insertNodeAtBegining(10);
        Node.insertNodeAtBegining(8);
        Node.insertNodeAtBegining(6);
        Node.insertNodeAtBegining(1);
        Node.displayLinkedList();
        Node.insertNodeAtPosition(100,5);
        Node.displayLinkedList();
        Node.deleteFirstNode();
        Node.displayLinkedList();
        System.out.println(Node.postionOfNodeWithData(45));
    }
}
