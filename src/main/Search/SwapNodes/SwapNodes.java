package main.Search.SwapNodes;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    문제를 이해 못해서 디스커션을 보고 겨우 이해했는데 대략 다들 문제를 이해 못하겠다는 분위기 (사람 다 똑같구만..)
    중위 순회를 하되, 특정 높이의 입력이 주어지면 해당 입력의 배수에 해당하는 자식 노드를 스왑하는 문제다.
 */
class Node{
    int data;
    int depth;
    Node left;
    Node right;
    Node (int data, int depth){
        this.data = data;
        this.depth = depth;
    }
}

public class SwapNodes {
    public static void swap_node(Node root, int K){
        if(root != null){
            if(root.depth%K == 0){
                Node temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
            swap_node(root.left, K);
            swap_node(root.right,K);
        }
    }

    public static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data+ " ");
            inorder(root.right);
        }

    }

    public static void print_nodes(Node root,int K){
        swap_node(root, K);
        inorder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Node> nodes = new LinkedList<>();
        Node root = new Node(1,1);
        Node cur = root;
        nodes.offer(cur);
        while(N-->0){
            cur  = nodes.poll();
            int leftdata = sc.nextInt();
            int rightdata = sc.nextInt();
            cur.left = (leftdata == -1) ? null : new Node(leftdata,cur.depth+1);
            cur.right = (rightdata == -1) ? null : new Node(rightdata,cur.depth+1);
            if(cur.left != null && cur.left.data != -1){
                nodes.offer(cur.left);
            }
            if(cur.right != null && cur.right.data != -1){
                nodes.offer(cur.right);
            }
        }
        int T = sc.nextInt();
        while(T-->0){
            int K = sc.nextInt();
            print_nodes(root,K);
        }


    }
}
