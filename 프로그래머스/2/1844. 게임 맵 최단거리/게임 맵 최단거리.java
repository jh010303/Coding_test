import java.util.*;

class Solution {
    class V{
        int y;
        int x;
        int n;
        public V(int y, int x, int n){
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }
    
    Queue<V> que = new LinkedList<>();
    boolean[][] visited;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int answer = 26;
        int m = maps.length; int n = maps[0].length;
        
        visited = new boolean[m][n];
        if(maps[0][0]==1){
            visited[0][0] = true;
            que.offer(new V(0,0,0));
        }
        
        while(!que.isEmpty()){
            V cur = que.poll();
            int cy = cur.y; int cx = cur.x; int cn = cur.n;
            for(int i=0; i<4; i++){
                int ny = cy+dy[i]; int nx = cx+dx[i]; int nn = cn+1;
                if(ny<0 || ny>=m || nx<0 || nx>=n || visited[ny][nx] || maps[ny][nx]==0){
                    continue;
                }
                
                if(ny==m-1 && nx==n-1){
                    answer = nn+1;
                    que.clear();
                    break;
                }
                
                visited[ny][nx]=true;
                que.offer(new V(ny,nx,nn));
            }
        }
        
        
        return answer==26?-1:answer;
    }
}