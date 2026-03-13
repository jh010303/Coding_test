import java.util.*;

class Solution {
    static class Cord{
        int y;
        int x;
        public Cord(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1}; 
    static Queue<Cord> que = new LinkedList<>();
    
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int mapH = maps.length; int mapW = maps[0].length();
        map = new char[mapH][mapW];
        visited = new boolean[mapH][mapW];
        
        for(int i=0; i<mapH; i++){
            for(int j=0; j<mapW; j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0; i<mapH; i++){
            for(int j=0; j<mapW; j++){
                if(!visited[i][j] && map[i][j]!='X'){
                    int sum = 0;
                    visited[i][j] = true;
                    que.offer(new Cord(i,j));
                    while(!que.isEmpty()){
                        Cord cur = que.poll();
                        sum+=(map[cur.y][cur.x]-'0');
                        for(int r=0; r<4; r++){
                            int nextY = cur.y+dy[r]; int nextX = cur.x+dx[r];
                            if(nextY<0 || nextX<0 || nextY>=mapH || nextX>=mapW || visited[nextY][nextX] || map[nextY][nextX]=='X'){
                                continue;
                            }
                            visited[nextY][nextX] = true;
                            que.offer(new Cord(nextY,nextX));
                        }
                    }
                    answer.add(sum);
                }
            }
        }
        
        Collections.sort(answer);
        if(answer.size()==0){
            answer.add(-1);
        }
        return answer;
    }
}