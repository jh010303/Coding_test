import java.util.*;
//System.out.println();
            
class Solution {
    static class Cord{
        int y;
        int x;
        int cnt;
        public Cord(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    
    static Queue<Cord> que = new LinkedList<>();
    static List<Cord> pPos = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    static boolean[][] visited = new boolean[5][5];
    static char[][] map = new char[5][5];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int pPosIndex = 0;
    
    public List<Integer> solution(String[][] places) {
        for(int i=0; i<5; i++){ // 전체 반복
            initMap(places,i);  
            boolean success = true;  // 거리두기를 지키는지 확인
            for(int j=0; j<pPos.size(); j++){ // p만큼 반복
                initVisited(pPosIndex++);
                Cord temp = pPos.get(j);
                que.offer(temp);
                visited[temp.y][temp.x] = true;
                while(!que.isEmpty() && success){
                    Cord cur = que.poll();
                    int cy = cur.y; int cx = cur.x; int ct = cur.cnt;
                    for(int r=0; r<4; r++){
                        int ny = cy+dy[r]; int nx = cx+dx[r]; int nt = ct+1;
                        if(ny<0 || nx<0 || ny>=5 || nx>=5 || map[ny][nx]=='X'||visited[ny][nx]){
                            continue;
                        }
                        if(map[ny][nx]=='P' && nt<=2){
                            success = false;
                            break;
                        }
                        Cord next = new Cord(ny,nx,nt);
                        visited[ny][nx] = true;
                        que.offer(next);
                    }
                }
                if(!success)break;
            }
            if(success){
                answer.add(1);
            }
            else{
                answer.add(0);
            }
        } 
        
        return answer;
    }
    
    static void initVisited(int s){
        for(int i=0; i<5; i++){
            Arrays.fill(visited[i],false);
        }
        for(int i=0; i<s; i++){
            Cord cur = pPos.get(i);
            visited[cur.y][cur.x] = true;
        }
    }
    
    static void initMap(String[][] places, int s){
        pPos.clear();
        que.clear();
        pPosIndex = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                map[i][j] = places[s][i].charAt(j);
                if(map[i][j] == 'P'){
                    pPos.add(new Cord(i,j,0));
                }
            }
        }
    }
}