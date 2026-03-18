import java.util.*;
class Solution {
    static Queue<Integer> que = new LinkedList<>();
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        map = new int[rows+1][columns+1];
        int fill = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j]=fill++;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int min = Integer.MAX_VALUE;
            int y1 = queries[i][0]; int x1 = queries[i][1];
            int y2 = queries[i][2]; int x2 = queries[i][3];
            int height = y2-y1; int width = x2-x1;
            int curY = y1; int curX = x1;
            // 큐에 담음
            for(int r=0; r<4; r++){
                if(r%2==0){ // width
                    for(int j=0; j<width; j++){
                        curY = curY+dy[r]; curX = curX+dx[r];
                        que.offer(map[curY][curX]);
                    }
                }
                else{ // height
                    for(int j=0; j<height; j++){
                        curY = curY+dy[r]; curX = curX+dx[r];
                        que.offer(map[curY][curX]);
                    }
                }
            }
            
            // 큐 회전
            int queSize = que.size();
            for(int j=0; j<queSize-1; j++){
                que.offer(que.poll());
            }
            
            // map에 회전 적용
            for(int r=0; r<4; r++){
                if(r%2==0){ // width
                    for(int j=0; j<width; j++){
                        int e = que.poll();
                        curY = curY+dy[r]; curX = curX+dx[r];
                        map[curY][curX]=e;
                        min = Math.min(min,e);
                    }
                }
                else{ // height
                    for(int j=0; j<height; j++){
                        int e = que.poll();
                        curY = curY+dy[r]; curX = curX+dx[r];
                        map[curY][curX]=e;
                        min = Math.min(min,e);
                    }
                }
            }
            answer.add(min);
        }
        return answer;
    }
}