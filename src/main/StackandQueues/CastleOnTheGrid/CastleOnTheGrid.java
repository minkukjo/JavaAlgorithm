package main.StackandQueues.CastleOnTheGrid;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    BFS 응용 문제
    Step Size가 1이 아니라 여러칸 움직여서 이동하게 함.
    일반적인 BFS로 풀되,
 */

class Castle {
    private int x;
    private int y;

    Castle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class CastleOnTheGrid {

    private static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int n = grid.length;

        Queue<Castle> queue = new LinkedList<>();
        int[][] minMove = new int[n][n];

        queue.add(new Castle(startX, startY));

        minMove[startX][startY] = 1;

        while (!queue.isEmpty()) {
            Castle castle = queue.poll();
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < n; j++) {
                    int nx = castle.getX() + (dx[i] * j);
                    int ny = castle.getY() + (dy[i] * j);

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx].charAt(ny) == 'X' ||
                            !(nx >= 0 && ny >= 0 && nx < n && ny < n)) {
                        break;
                    }

                    if (minMove[nx][ny] == 0) {
                        if (nx == goalX && ny == goalY) {
                            return minMove[castle.getX()][castle.getY()];
                        }
                        queue.add(new Castle(nx, ny));
                        minMove[nx][ny] = minMove[castle.getX()][castle.getY()] + 1;

                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            grid[i] = temp;
        }
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int goalX = sc.nextInt();
        int goalY = sc.nextInt();

        System.out.println(minimumMoves(grid, startX, startY, goalX, goalY));

    }
}
