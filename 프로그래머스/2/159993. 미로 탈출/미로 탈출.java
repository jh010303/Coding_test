import java.util.*;

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
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int mapSizeY,mapSizeX,lY,lX;
    static Queue<Cord> que = new LinkedList<>();
    
    public int solution(String[] maps) {
        int answer = 0;
        mapSizeY = maps.length;
        mapSizeX = maps[0].length();
        map = new char[mapSizeY][mapSizeX];
        visited = new boolean[mapSizeY][mapSizeX];
        for(int i=0; i<mapSizeY; i++){
            String temp = maps[i];
            for(int j=0; j<mapSizeX; j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j]=='S'){
                    visited[i][j]=true;
                    que.offer(new Cord(i,j,0));
                }
                else if(map[i][j]=='L'){
                    lY= i; lX = j;
                }
            }
        }
        
        // 레버까지 최소
        int time = Integer.MAX_VALUE;
        boolean success = false;
        while(!que.isEmpty()){
            Cord cur = que.poll();
            int curT = cur.t; int curY = cur.y; int curX = cur.x;
            
            for(int i=0; i<4; i++){
                int nextY = curY+dy[i]; int nextX = curX+dx[i]; int nextT = curT+1;
                if(nextY<0 || nextX<0 || nextY>=mapSizeY || nextX>=mapSizeX || 
                   visited[nextY][nextX] || map[nextY][nextX]=='X')continue;
                
                if(map[nextY][nextX]=='L'){
                    time = nextT;
                    success=true;
                    break;
                }
                else{
                    visited[nextY][nextX] = true;
                    que.offer(new Cord(nextY,nextX,nextT));
                }
            }
            
            if(success){
                break;
            }
        }
        
        if(time==Integer.MAX_VALUE){
            return -1;
        }
        else{
            for(int i=0; i<mapSizeY; i++){
                Arrays.fill(visited[i],false);
            }
            que.clear();
            que.offer(new Cord(lY,lX,time));
            visited[lY][lX]=true;
            success = false;
            while(!que.isEmpty()){
                Cord cur = que.poll();
                int curT = cur.t; int curY = cur.y; int curX = cur.x;

                for(int i=0; i<4; i++){
                    int nextY = curY+dy[i]; int nextX = curX+dx[i]; int nextT = curT+1;
                    if(nextY<0 || nextX<0 || nextY>=mapSizeY || nextX>=mapSizeX || 
                       visited[nextY][nextX] || map[nextY][nextX]=='X')continue;

                    visited[nextY][nextX] = true;
                    if(map[nextY][nextX]=='E'){
                        answer = nextT;
                        success=true;
                        break;
                    }
                    else{
                        que.offer(new Cord(nextY,nextX,nextT));
                    }
                }

                if(success){
                    break;
                }
            }
        }
        
        return answer==0?-1:answer;
    }
}