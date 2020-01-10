package main.LinkedList.DetectCycle;

class Node{
    int data;
    Node next;
}

public class DetectCycle {

    boolean hasCycle(Node head) {
        if(head == null) return false;
        Node first = head;
        Node second = head.next;

        while(first != second){
            if(second == null || second.next == null) return false;
            first = first.next;
            second= second.next.next;

        }

        return true;

    }
}
