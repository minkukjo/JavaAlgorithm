package main.LinkedList.Insert;

import java.util.Scanner;

/*
    갑자기 정의되지도 않은 클래스 생성자 타입 안맞췄다고 오류 내는 수듄...
    띠용한 문제였다
 */

class SinglyLinkedListNode{
    int data;
    SinglyLinkedListNode next;
}

public class Insert {
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode target = new SinglyLinkedListNode();
        for(int i=0; i<position-1; i++){
            temp = temp.next;
        }
        target.data = data;
        target.next = temp.next;
        temp.next = target;
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        SinglyLinkedListNode head = new SinglyLinkedListNode();
        head.data = sc.nextInt();
        for(int i=0; i<n-1; i++){
            SinglyLinkedListNode temp = head;
            SinglyLinkedListNode insert = new SinglyLinkedListNode();
            insert.data = sc.nextInt();
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = insert;
        }

        int data = sc.nextInt();
        int position = sc.nextInt();
        insertNodeAtPosition(head,data,position);
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
