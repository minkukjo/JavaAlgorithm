package main.StackandQueues.TaleOfTwoStacks;

import java.util.Scanner;
import java.util.Stack;

/*
    굉장히 띠용한 문제였다.
    스택 2개로 큐를 구현할줄은 알았지만,
    구체적으로 어떻게 구현하는지 물어봤을 때 이렇게 짜낼 수 있다.
 */

class MyQueue<T>{
    Stack<T> fifo = new Stack<>();
    Stack<T> lifo = new Stack<>();

    void enqueue(T value){
        if(fifo.isEmpty()){
            fifo.push(value);
            return;
        }
        lifo.push(value);

    }
    T peek(){
        return fifo.peek();
    }

    void dequeue(){
        fifo.pop();
        if(fifo.isEmpty()){
            while(!lifo.isEmpty()){
                fifo.push(lifo.pop());
            }
        }
    }
}

public class TaleOfTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
    }
}
