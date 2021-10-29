package main.BaekJoon.N3055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;
    int time;

    Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class N3055 {

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] map = new int[x][y];
        Queue<Point> S = new LinkedList<>();
        Queue<Point> W = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            String str = sc.next();
            for (int j = 0; j < y; j++) {
                char c = str.charAt(j);
                if (c == 'D') {
                    map[i][j] = 2;
                } else if (c == '*') {
                    map[i][j] = 1;
                    W.offer(new Point(i, j, 0));
                } else if (c == 'S') {
                    map[i][j] = 0;
                    S.offer(new Point(i, j, 0));
                } else if (c == 'X') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        boolean[][] visit = new boolean[x][y];
        boolean isFound = false;
        while (true) {

            int size = W.size();

            for (int j = 0; j < size; j++) {
                Point water = W.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = water.x + dx[i];
                    int ny = water.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < x && ny < y && map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        W.offer(new Point(nx, ny, 0));
                    }
                }
            }


            size = S.size();
            for (int j = 0; j < size; j++) {
                Point hedgehog = S.poll();
                visit[hedgehog.x][hedgehog.y] = true;

                if (map[hedgehog.x][hedgehog.y] == 2) {
                    System.out.println(hedgehog.time);
                    isFound = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = hedgehog.x + dx[i];
                    int ny = hedgehog.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < x && ny < y && (map[nx][ny] == 0 || map[nx][ny] == 2) && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        S.offer(new Point(nx, ny, hedgehog.time + 1));
                    }
                }
            }

            if (size == 0) {
                break;
            }

            if (isFound) {
                break;
            }
        }

        if (!isFound) {
            System.out.println("KAKTUS");
        }


    }
}
