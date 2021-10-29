package main.LinkedList.FindMergePoint;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}

public class FindMergePoint {
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode temp1 = head1;
        SinglyLinkedListNode temp2 = head2;

        while (temp1 != temp2) {
            if (temp1.next == null) {
                temp1 = head2;
            } else {
                temp1 = temp1.next;
            }

            if (temp2.next == null) {
                temp2 = head1;
            } else {
                temp2 = temp2.next;
            }
        }
        return temp2.data;

    }
}
