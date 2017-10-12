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
    BinarySearchTree(){
        root = null;
    }

    public void makeBinarySearchTreeEmpty(){
        root = null;
    }

    public void insert(int data) {
        Node node = new Node(data, 0, null, null);

        if (Objects.isNull(root)) {
            root = node;
            return;
        }
        Node nodeNext = root;
        Node nodePrevious = null;
        while (nodeNext != null) {
            if (data > nodeNext.data) {
                nodePrevious= nodeNext;
                nodeNext.size+=1;
                nodeNext = nodeNext.right;
            } else {
                nodePrevious = nodeNext;
                nodeNext.size+=1;
                nodeNext = nodeNext.left;
            }
        }
        if(data> nodePrevious.data){
            nodePrevious.right = node;
        }
        else nodePrevious.left = node;

    }


    public void inorderTraversal(Node node){
        if(node.left!=null)
            inorderTraversal(node.left);
        System.out.println(node.data);
        if(node.right!=null)
            inorderTraversal(node.right);
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(6);
        bst.insert(5);
        bst.insert(1);
        bst.insert(2);
        bst.inorderTraversal(bst.root);
    }
}
