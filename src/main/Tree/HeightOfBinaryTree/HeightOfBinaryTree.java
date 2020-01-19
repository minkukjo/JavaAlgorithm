package main.Tree.HeightOfBinaryTree;

class Node{
    int data;
    Node left;
    Node right;
}

public class HeightOfBinaryTree {
    public static int answer;
    public static void postOrder(Node root, int depth){
        if(root == null) return;

        postOrder(root.left,depth+1);
        postOrder(root.right,depth+1);
        answer = Math.max(depth,answer);
    }
    public static int height(Node root) {
        // Write your code here.

        postOrder(root,0);

        return answer;
    }

}
