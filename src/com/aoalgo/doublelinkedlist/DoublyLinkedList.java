package doublelinkedlist;

import linkedlist.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by User on 07-Sep-17.
 */
public class DoublyLinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;
        Node(T data, Node<T> next, Node<T> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    DoublyLinkedList(){
        head=null;
    }

    public void addFirst(T data){
        Node<T> node = new Node<>(data, head, null);
        if(!Objects.isNull(head)){
            head.prev= node;
        }
        head = node;
    }

    public void addLast(T data){

        Node<T> nodeNext = head;
        Node<T> node = new Node<>(data, null, null);
        if(Objects.isNull(head)){
            head = node;
        }
        else {
            while (!Objects.isNull(nodeNext.next)) {
                nodeNext = nodeNext.next;
            }
            nodeNext.next = node;
            node.prev=nodeNext;
        }
    }

    public void insertBefore(T data, T newData){
        Node<T> nodeNext = head;
        Node<T> node = new Node<>(newData, null, null);
        while(!Objects.isNull(nodeNext)){
            if(Objects.equals(data, nodeNext.data)){
                node.prev = nodeNext.prev;
                node.next = nodeNext;
                if(!Objects.isNull(nodeNext.prev)){
                    nodeNext.prev.next = node;
                }
                nodeNext.prev = node;
                return;
            }
            nodeNext = nodeNext.next;
        }
        throw new NoSuchElementException();

    }

    public boolean findKey(T key){
        for(T item:this){
            if(Objects.equals(item, key))
                return true;
        }
        return false;
    }

    public void insertAfter(T data, T newData){

        Node<T> nodeNext = head;
        Node<T> node = new Node<>(newData, null, null);
        while(!Objects.isNull(nodeNext)){
            if(Objects.equals(nodeNext.data, data)){
                node.next= nodeNext.next;
                node.prev = nodeNext;
                if(!Objects.isNull(nodeNext.next)){
                    nodeNext.next.prev= node;
                }
                nodeNext.next = node;
                return;
            }
            nodeNext = nodeNext.next;
        }
        throw new NoSuchElementException();
    }

    public boolean isEmpty(){
        return Objects.isNull(head);
    }

    public void makeEmptyDList(){
        head=null;
    }

    @Override
    public String toString() {
        String output = new String("");
        for(T item: this)
            output += item + " ";

        return output;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> nodeNext;
            {
                nodeNext= head;
            }
            @Override
            public boolean hasNext() {

                return !Objects.isNull(nodeNext);
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                else{
                    Node<T> node = nodeNext;
                    nodeNext = nodeNext.next;
                    return node.data;
                }

            }
        };
    }


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        DoublyLinkedList<Integer> dllst = new DoublyLinkedList<>();
        int n = in.nextInt();
        while(n>0){
            dllst.addFirst(in.nextInt());
            n--;
        }


        System.out.println(dllst);
        System.out.println(dllst.findKey(5));
//        System.out.println(llst.head.data);
        System.out.println(dllst.isEmpty());
        dllst.insertAfter(2, 6);
        System.out.println("hola");
//        dllst.insertAfter(9, 10);
        dllst.insertBefore(2, 1);
        System.out.println(dllst.isEmpty());
        System.out.println(dllst);
    }
}
