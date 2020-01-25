package main.Deque;

public class Deque<E> {
    private Node<E> front;
    private Node<E> rear;

    Deque(){
        this.front = null;
        this.rear = null;
    }

    private boolean isEmpty(){
        if(front == null) return true;
        else return false;
    }

    public void addFirst(E data){
        if(isEmpty()){
            this.front = new Node<E>(data);
            this.rear = this.front;
            return;
        }
        front.setPrev(new Node<E>(data));
        front.getPrev().setNext(front);
        front = front.getPrev();
    }
    public void addLast(E data){
        if(isEmpty()){
            this.rear = new Node<E>(data);
            this.front = rear;
            return;
        }
        rear.setNext(new Node<E>(data));
        rear.getNext().setPrev(rear);
        rear = rear.getNext();
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E temp = front.getData();
        if(front == rear){
            front = null;
            rear = null;
            return temp;
        }
        front = front.getNext();
        front.setPrev(null);
        return temp;

    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        E temp = rear.getData();
        if(front == rear){
            front = null;
            rear = null;
            return temp;
        }
        rear = rear.getPrev();
        rear.setNext(null);
        return temp;
    }

    public Node<E> getFront() {
        return front;
    }

    public void setFront(Node<E> front) {
        this.front = front;
    }

    public Node<E> getRear() {
        return rear;
    }

    public void setRear(Node<E> rear) {
        this.rear = rear;
    }
}
