package main.DFSBFS.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 백준 1068번
public class Tree {
    static List<Integer>[] adjust;
    static boolean[] visited;
    static int leaf = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        adjust = new ArrayList[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            adjust[i] = new ArrayList<>();
            visited[i] = false;
        }
        int root = 0;
        for(int i=0; i<n; i++) {
            int parent = sc.nextInt();
            if(parent == -1) {
                root = i;
            } else {
                adjust[parent].add(i);
            }
        }
        int deletedNode = sc.nextInt();
        if(deletedNode == root) {
            System.out.println("0");
        } else {
            dfs(root, deletedNode);
            System.out.println(leaf);
        }
    }

    public static void dfs(int node, int deletedNode) {
        visited[node] = true;
        int child = 0;
        for(int i=0; i<adjust[node].size(); i++) {
            int childNode = adjust[node].get(i);
            if(!visited[childNode] && childNode != deletedNode) {
                child++;
                dfs(childNode, deletedNode);
            }
        }
        if(child == 0) {
            leaf++;
        }
    }
}
