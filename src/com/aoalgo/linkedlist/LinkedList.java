package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by User on 01-Sep-17.
 */
public class LinkedList<T> implements Iterable<T>{

    public Node<T> head;
    private static class Node<T>{
        T data;
        Node<T> next;
        Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }

    public LinkedList(){
        head =null;
    }

    public boolean isEmpty(){
        return Objects.isNull(head);
    }

    public void makeListEmpty(){
        head=null;
    }


    private class LinkedListIterator implements Iterator<T>{
        private Node<T> nextNode;

        public LinkedListIterator(){
            nextNode=head;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                Node<T> node = nextNode;
                nextNode=nextNode.next;
                return node.data;
            }
        }

        @Override
        public boolean hasNext() {
            return !Objects.isNull(nextNode);
        }

        @Override
        public void remove() { throw new UnsupportedOperationException(); }
    }

    void addFirst(T data){
        Node<T> node = new Node<>(data, null);
        if(Objects.isNull(this.head)){
            head = node;
        }
        else{
            node.next=head;
            head = node;
        }
    }

    void addLast(T data){
        Node<T> nodeNext = head;
        if(Objects.isNull(nodeNext)){
            Node<T> node = new Node<>(data, null);
            head=node;
            nodeNext=node;
        }
        else {
            while (!Objects.isNull(nodeNext.next)) {
                nodeNext = nodeNext.next;
            }
            Node<T> node = new Node<>(data, null);
            nodeNext.next = node;
        }
    }

    boolean findKey(T key){
        for(T item: this){
            if(key.equals(item))
                return true;
        }
        return false;
    }

    void insertBefore(T data, T newData){
        Node<T> nodePrevious = null;
        Node<T> nodeNext = head;
        while(!Objects.isNull(nodeNext)){
            if(nodeNext.data.equals(data)){
                Node<T> node = new Node<>(newData, null);
                if(Objects.isNull(nodePrevious)){
                    node.next=nodeNext;
                    head = node;
                    return;
                }
                else {
                    nodePrevious.next = node;
                    node.next = nodeNext;
                    return;
                }
            }
            nodePrevious = nodeNext;
            nodeNext = nodeNext.next;
        }
        throw new NoSuchElementException();
    }

    void insertAfter(T data, T newData){
        Node<T> nodeNext = head;
        while(!Objects.isNull(nodeNext)){
            if(nodeNext.data.equals(data)){
                Node<T> node = new Node<>(newData, null);
                node.next= nodeNext.next;
                nodeNext.next=node;
                return;
            }
            nodeNext = nodeNext.next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        String output="";
        for(T item: this){
            output=output + " " + item.toString();
        }
        return output;
    }

    @Override
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    public Node<T> reverse(){
        if(head==null)
            return head;

        Node<T> nodeNext = head.next;
        head.next=null;
        Node<T> temp = null;
        while(nodeNext!=null){
            Node<T> temp2 = nodeNext;
            temp = nodeNext;
            nodeNext = temp.next;
            temp2.next = head;
            head= temp2;
        }
        return head;

    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        LinkedList<Integer> llst = new LinkedList<>();
        int n = in.nextInt();
        while(n>0){
            llst.addFirst(in.nextInt());
            n--;
        }


        System.out.println(llst);
        System.out.println(llst.reverse().data);
        System.out.println(llst.findKey(5));
//        System.out.println(llst.head.data);
        System.out.println(llst.isEmpty());
        llst.insertAfter(2, 6);
        System.out.println("hola");
        llst.insertAfter(9, 10);
        llst.insertBefore(2, 1);
        System.out.println(llst.isEmpty());
        System.out.println(llst);
    }
}
