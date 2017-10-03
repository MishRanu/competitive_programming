package binarysearchtree;

import java.util.Objects;

/**
 * Created by User on 23-Sep-17.
 */
public class BinarySearchTree {

    Node root;

    class Node{
        int data;
        int size;
        Node left;
        Node right;
        Node(int data, int size, Node left, Node right){
            this.data = data;
            this.size = size;
            this.left = left;
            this.right = right;
        }
    }

    public void makeBinarySearchTreeEmpty(){
        root = null;
    }

    public void insert(int data) {
        if (Objects.isNull(root)) {
            Node temp = new Node(data, 0, null, null);
            root = temp;
            return;
        }
        Node nodeNext = root;
        Node nodePrevious = null;
        while (nodeNext != null) {
            if (data > nodeNext.data) {
                nodePrevious
                nodeNext = nodeNext.right;
            } else {
                nodeNext = nodeNext.left;
            }
        }
    }


    public static void main(String[] args){


    }
}
