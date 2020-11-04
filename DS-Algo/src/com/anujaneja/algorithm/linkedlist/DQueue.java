package com.anujaneja.algorithm.linkedlist;

public class DQueue<T> {
    private Node<T> head;
    private Node<T> tail;

    public DQueue() {
        this.head = new Node<>();
        this.tail = new Node<>();
    }

    public static void main(String[] args) {
        DQueue<Integer> dQueue = new DQueue<>();
        dQueue.insertFirst(1);
        dQueue.insertFirst(2);
        dQueue.insertFirst(3);
        dQueue.insertLast(2);
        dQueue.insertLast(3);
        dQueue.insertLast(4);
        dQueue.insertLast(5);


        dQueue.printElements();

    }

    public void insertFirst(T element) {
        Node<T> temp = this.head.getNext();
        Node<T> node = new Node<>(element);
        this.head.setNext(node);
        node.setPre(this.head);

        if (temp == null) {
            this.tail.setPre(node);
            node.setNext(tail);
        } else {
            node.setNext(temp);
        }
    }

    public void insertLast(T element) {
        Node<T> temp = this.tail.getPre();
//        System.out.println(">>>= "+temp.getData());
        Node<T> node = new Node<>(element);
        this.tail.setPre(node);
        node.setNext(tail);

        if (temp == null) {
            this.head.setNext(node);
            node.setPre(this.head);
        } else {
            node.setPre(temp);
            temp.setNext(node);
        }
    }

    public void removeFirst() {
        Node<T> node = this.head.getNext();

        if (node != null && this.head.getNext() != this.tail.getPre()) {
            this.head.setNext(node.getNext());
            this.head.getNext().setPre(head);
        } else if (node != null && this.head.getNext() == this.tail.getPre()) {
            this.head.setNext(null);
            this.tail.setPre(null);
        }
    }

    public void removeLast() {
        Node<T> node = this.tail.getPre();

        if (node != null && this.head.getNext() != this.tail.getPre()) {
            this.tail.setPre(node.getPre());
            this.tail.getPre().setNext(this.tail);
        } else if (node != null && this.head.getNext() == this.tail.getPre()) {
            this.head.setNext(null);
            this.tail.setPre(null);
        }
    }

    public T first() {
        return this.head.getNext() != null ? this.head.getNext().getData() : null;
    }

    public T last() {
        return this.tail.getPre() != null ? this.head.getPre().getData() : null;
    }

    public void printElements() {
        Node<T> node = head.getNext();

        while(node!=null && node!=tail) {
            System.out.println(node.getData());
            node=node.getNext();
        }
    }
}

class Node<T> {
    private T       data;
    private Node<T> next;
    private Node<T> pre;

    public Node() {
        this.data = null;
        this.next = null;
        this.pre = null;
    }

    public Node(T data) {
        this.data = data;
        this.next = new Node<>();
        this.pre = new Node<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPre() {
        return pre;
    }

    public void setPre(Node<T> pre) {
        this.pre = pre;
    }
}
