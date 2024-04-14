package 백준문제풀이.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진_검색_트리 {
    public static void main(String[] args) throws IOException {
        BinarySearchTree bst = new BinarySearchTree();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input = br.readLine();
            if (input == null || input.equals(""))
                break;
            bst.add(Integer.parseInt(input));
        }
        postOrder(bst.root);
    }

    static void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

}

class Node {
    Node left = null;
    Node right = null;
    Integer key = null;
}

class BinarySearchTree {
    Node root = null;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            root = addNode(root, newNode);
        }
    }

    private Node addNode(Node node, Node newNode) {
        if (node == null)
            return newNode;
        else if (node.key > newNode.key)
            node.left = addNode(node.left, newNode);
        else
            node.right = addNode(node.right, newNode);

        return node;
    }
}
