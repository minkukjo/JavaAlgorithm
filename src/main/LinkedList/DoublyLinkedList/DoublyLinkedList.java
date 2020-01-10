package main.LinkedList.DoublyLinkedList;

import java.util.Scanner;

class DoublyLinkedListNode{
    int data;
     DoublyLinkedListNode next;
     DoublyLinkedListNode prev;
    DoublyLinkedListNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode insert = new DoublyLinkedListNode(data);
        if(head == null){
            return insert;
        }
        else if(data <head.data){
            insert.next = head;
            head.prev = insert;
            return insert;
        }else{
            DoublyLinkedListNode n1 = null;
            DoublyLinkedListNode n2 = head;

            while(n2 != null && n2.data < data){
                n1 = n2;
                n2 = n2.next;
            }

            if(n2 == null){
                n1.next = insert;
                insert.prev = n1;
            }else{
                n1.next = insert;
                n2.prev = insert;
                insert.prev = n1;
                insert.next = n2;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DoublyLinkedListNode head = new DoublyLinkedListNode(sc.nextInt());
        for(int i=0; i<n; i++){
            head = sortedInsert(head,sc.nextInt());
        }

        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }

    }
}
