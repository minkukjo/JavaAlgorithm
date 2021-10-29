package main.Graph.BFS;

import java.util.*;

/*
    Visit으로 하니까 안되고, HashSet으로 하니까 되네 흠;
    전형적인 BFS문제
    BFS나 DFS 문제들은 코드가 길어서 귀찮다.
 */

class Node {
    public int index;
    public int depth;

    Node(int index, int depth) {
        this.index = index;
        this.depth = depth;
    }
}

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int t = 0; t < q; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer>[] adjancyList = new ArrayList[n + 1];
            int[] answer = new int[n + 1];
            Arrays.fill(answer, -1);

            for (int i = 0; i <= n; i++) {
                adjancyList[i] = new ArrayList<>();
            }


            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                int firstNode = sc.nextInt();
                int secondNode = sc.nextInt();

                adjancyList[firstNode].add(secondNode);
                adjancyList[secondNode].add(firstNode);
            }

            int start = sc.nextInt();
            HashSet<Integer> seen = new HashSet<>();

            queue.add(new Node(start, 0));
            seen.add(start);

            while (!queue.isEmpty()) {
                Node top = queue.poll();
                for (int i = 0; i < adjancyList[top.index].size(); i++) {
                    if (!seen.contains(adjancyList[top.index].get(i))) {
                        seen.add(adjancyList[top.index].get(i));
                        queue.add(new Node(adjancyList[top.index].get(i), top.depth + 6));
                        answer[adjancyList[top.index].get(i)] = top.depth + 6;
                    }

                }
            }

            for (int i = 1; i <= n; i++) {
                if (i == start) {
                    continue;
                }
                if (answer[i] == 0) {
                    answer[i] = -1;
                }
                if (i == n) {
                    System.out.print(answer[i]);
                } else {
                    System.out.print(answer[i] + " ");
                }
            }

            System.out.println();

        }


    }
}
