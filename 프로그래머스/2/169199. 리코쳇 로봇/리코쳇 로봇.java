import java.util.*;
import java.io.*;

class Solution {
    static class Cord{
        int y;
        int x;
        int t;
        public Cord(int y, int x, int t){
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }
    static Queue<Cord> que = new LinkedList<>();
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int GX, GY, RX,RY;
    public int solution(String[] board) {
        int answer = 0;
        boolean success = false;
        initMap(board);
        while(!que.isEmpty()){
            Cord cur = que.poll();
            int curY = cur.y; int curX = cur.x; int curT = cur.t;
            if(curY==GY && curX==GX){
                answer = curT;
                break;
            }
            for(int i=0; i<4; i++){
                int t = 1;
                int nextY = 0; int nextX = 0; int nextT = 0;
                while(true){
                    nextY = cur.y+dy[i]*t; nextX = cur.x+dx[i]*t;
                    if(nextY<0 || nextX<0 || nextY>=map.length || nextX>=map[0].length || map[nextY][nextX]=='D'){
                        break;
                    }
                    t++;
                }
                nextY = nextY-dy[i]; nextX = nextX-dx[i]; nextT = curT+1;
                if(!visited[nextY][nextX]){
                    visited[nextY][nextX]=true;
                    que.offer(new Cord(nextY,nextX,nextT));
                }
            }
        }
        return answer==0?-1:answer;
    }
    
    static void initMap(String[] board){
        map = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j]=='R'){
                    RY = i; RX = j;
                    visited[RY][RX] = true;
                    que.offer(new Cord(RY,RX,0));
                }
                else if(map[i][j]=='G'){
                    GY = i; GX = j;
                }
            }
        }
    }
}