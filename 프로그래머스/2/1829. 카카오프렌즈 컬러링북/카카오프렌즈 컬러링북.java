import java.util.*;

class Solution {
    class Cord{
        int y;
        int x;
        public Cord(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    Queue<Cord> que = new LinkedList<>();
    boolean[][] visited = new boolean[101][101];
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j]!=0){
                    numberOfArea++;
                    visited[i][j] = true;
                    que.offer(new Cord(i,j));
                    int area = 0;
                    int color = picture[i][j];
                    while(!que.isEmpty()){
                        Cord cur = que.poll();
                        int cy = cur.y; int cx = cur.x;
                        for(int r=0; r<4; r++){
                            int ny = cy+dy[r]; int nx = cx+dx[r];
                            if(ny<0 || nx<0 || ny>=m || nx>=n || visited[ny][nx] || picture[ny][nx]!=color){
                                continue;
                            }
                            visited[ny][nx] = true;
                            que.offer(new Cord(ny,nx));
                        }
                        area++;
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,area);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
