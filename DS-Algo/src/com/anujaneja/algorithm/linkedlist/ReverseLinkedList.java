package com.anujaneja.algorithm.linkedlist;

/**
 * Created by anuj on 05/11/17.
 */
public class ReverseLinkedList<E> {

    static class LinkedListNode<E> {
        E data;
        LinkedListNode<E> next;

    }

    static <E>  LinkedListNode<E> reverse(LinkedListNode<E> head) {


        if(head==null || head.next==null) {
            return head;
        }


        LinkedListNode<E> reverseList = null;
        LinkedListNode<E> current = head;

        while(current!=null) {
            LinkedListNode<E> next = current.next;
            current.next = reverseList;
            reverseList=current;
            current= next;
        }

        return reverseList;
    }

    static <E> void printElement(LinkedListNode<E> list) {
        while(list!=null) {

            System.out.print(list.data+" , ");
            list=list.next;
        }

    }

    public static void main(String[] s) {

        LinkedListNode<Integer> list = new LinkedListNode<>();
        list.data = 0;
        list.next = null;

        LinkedListNode<Integer> head = list;
        int i=1;

        while(i<11) {

            list.next = new LinkedListNode<>();
            list.next.data =  i;
            list.next.next = null;
            list=list.next;
            i++;
        }

        System.out.println(list);

        LinkedListNode<Integer> reversedList = reverse(head);

        printElement(reversedList);
    }
}
