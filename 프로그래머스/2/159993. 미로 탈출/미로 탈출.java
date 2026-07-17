import java.util.*;

class Solution {
    class Cord{
        int y;
        int x;
        int t;

        public Cord(int y, int x, int t){
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }
    
    Queue<Cord> que = new LinkedList<>();
    boolean[][] visited;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(String[] maps) {
        int answer = 10001;
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j)=='S'){
                    que.offer(new Cord(i,j,0));
                    visited[i][j] = true;
                    break;
                }
            }
        }
        
        boolean findL = false;
        boolean findE = false;
        while(!que.isEmpty()){
            if(findE){
                break;
            }
            Cord cur = que.poll();
            int cy = cur.y; int cx = cur.x; int ct = cur.t;
            for(int i=0; i<4; i++){
                int ny = cy+dy[i]; int nx = cx+dx[i]; int nt = ct+1;
                if(ny<0 || nx<0 || ny>=maps.length || nx>=maps[0].length() || visited[ny][nx] || 
                   maps[ny].charAt(nx)=='X'){
                    continue;
                }
                
                char status = maps[ny].charAt(nx);
                if(status=='E' && findL){
                    answer = nt;
                    findE = true;
                    break;
                }
                else if(status=='L' && !findL){
                    findL = true;
                    for(int j=0; j<visited.length; j++){
                        Arrays.fill(visited[j],false);
                    }
                    que.clear();
                    i=4;
                }
                
                visited[ny][nx] = true;
                que.offer(new Cord(ny,nx,nt));
            }
        }
        
        
        return answer==10001?-1:answer;
    }
}

// 레버를 무조건 당겨야함
// 출구는 근데 레버 안 당겨도 갈 수 있음
// bfs가 끝나는 시점은 레버를 당겼고, 출구에 도착했을 때