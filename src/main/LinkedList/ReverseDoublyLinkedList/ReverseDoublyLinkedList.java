package main.LinkedList.ReverseDoublyLinkedList;

import java.util.Scanner;

/*
    더블 링크드 리스트 뒤집기
 */

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

}
public class ReverseDoublyLinkedList {
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head.next;
        head.next = head.prev;
        head.prev = temp;
        return temp == null ? head : reverse(temp);
    }
}
