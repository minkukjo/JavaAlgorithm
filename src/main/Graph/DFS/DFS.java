package main.Graph.DFS;

import java.util.Scanner;

/*
    일반적인 nx,ny 완전탐색으로 안풀려서 답안을 참조한 문제
    알고보니 Cache를 이용하는게 아니라, 방문한 곳은 돌아오지 않고 연결된 모든 곳을 카운트해서 카운트 해야한다.
    추가 메모리 공간을 쓰지 않기 대문에 빠르고 심플하다.
 */

public class DFS {
    public static int[][] map;
    public static int answer;
    public static boolean[][] visit;
    public static int n;
    public static int m;
    public static int dfs(int x, int y){
        int result = 1;
        visit[x][y] = true;

        if(x +1 < n && map[x+1][y] == 1 && !visit[x+1][y]){
            visit[x+1][y] = true;
            result = Math.max(result,1+ dfs(x+1,y));
            visit[x+1][y] = false;
        }
        if(0<= x-1 && map[x-1][y] == 1 && !visit[x-1][y]){
            visit[x-1][y] = true;
            result = Math.max(result,1+ dfs(x-1,y));
            visit[x-1][y] = false;
        }
        if(y+1 < m && map[x][y+1] == 1 && !visit[x][y+1]){
            visit[x][y+1] = true;
            result = Math.max(result,1+ dfs(x,y+1));
            visit[x][y+1] = false;
        }
        if(0<=y-1 && map[x][y-1] == 1 && !visit[x][y-1]){
            visit[x][y-1] = true;
            result = Math.max(result,1+ dfs(x,y-1));
            visit[x][y-1] = false;
        }
        if(x+1 < n && y+1 <m && map[x+1][y+1] == 1 && !visit[x+1][y+1]){
            visit[x+1][y+1] = true;
            result = Math.max(result,1+ dfs(x+1,y+1));
            visit[x+1][y+1] = false;
        }
        if(0<=x-1 && 0<=y-1 && map[x-1][y-1] == 1 && !visit[x-1][y-1]){
            visit[x-1][y-1] = true;
            result = Math.max(result,1+ dfs(x-1,y-1));
            visit[x-1][y-1] = false;
        }
        if(0<= x-1 && y+1 <m && map[x-1][y+1] == 1 && !visit[x-1][y+1]){
            visit[x-1][y+1] = true;
            result = Math.max(result,1+ dfs(x-1,y+1));
            visit[x-1][y+1] = false;
        }
        if(x+1 < n && 0<= y-1 && map[x+1][y-1] == 1 && !visit[x+1][y-1]){
            visit[x+1][y-1] = true;
            result = Math.max(result,1+ dfs(x+1,y-1));
            visit[x+1][y-1] = false;
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 1){
                    answer = Math.max(answer,dfs(i,j));
                }
            }
        }

        System.out.println(answer);

    }
}
