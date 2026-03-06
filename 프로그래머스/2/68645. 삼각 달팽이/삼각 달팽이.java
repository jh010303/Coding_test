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
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx={0,1,-1};
    static int[] dy={1,0,-1};
    
    static Queue<Cord> que = new LinkedList<>();
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        arr = new int[n][n];
        visited = new boolean[n][n];
        int dir = 0, num=1;
        
        que.offer(new Cord(0,0));
        visited[0][0]=true;
        
        while(!que.isEmpty()){
            boolean turn = false;
            Cord cur = que.poll();
            int curY = cur.y; int curX = cur.x;
            arr[curY][curX] = num++;
            visited[curY][curX]=true;
            
            int nextY = curY+dy[dir]; int nextX=curX+dx[dir];
            if(nextY<0 || nextX<0 || nextY>=n || nextX>=n || visited[nextY][nextX]){
                dir = (dir+1)%3;
                turn = true;
            }
            if(turn){
                nextY = curY+dy[dir]; nextX=curX+dx[dir];
                if(nextY<0 || nextX<0 || nextY>=n || nextX>=n || visited[nextY][nextX]){
                    break;
                }
            }
            que.offer(new Cord(nextY,nextX));
        }
        
        int answerIndex=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int temp = arr[i][j];
                if(temp>=1){
                    answer[answerIndex++] = temp;
                }
            }
        }
        return answer;
    }
    
}