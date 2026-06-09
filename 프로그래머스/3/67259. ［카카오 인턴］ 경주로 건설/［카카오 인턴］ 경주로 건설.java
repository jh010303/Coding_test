import java.util.*;

class Solution {
    class Cord implements Comparable<Cord>{
        int y;
        int x;
        int w;
        boolean wid;
        boolean hei;
        public Cord(int y, int x, int w, boolean wid, boolean hei){
            this.y = y;
            this.x = x;
            this.w = w;
            this.wid = wid;
            this.hei = hei;
        }
        
        @Override
        public int compareTo(Cord c){
            return Integer.compare(this.w,c.w);
        }
        
    }
    
    PriorityQueue<Cord> que = new PriorityQueue<>();
    int[][][] st;
    int[] dy = {1,-1,0,0};
    int[] dx = {0,0,1,-1};
    int STARTY = 0; int STARTX = 0;
    
    public int solution(int[][] board) {
        st = new int[board.length][board.length][2];
        for(int i=0; i<st.length; i++){
            for(int j=0; j<st.length; j++){
                Arrays.fill(st[i][j],312500);
            }
        }
        
        que.offer(new Cord(STARTY,STARTX,0,false,false));
        st[STARTY][STARTX][0] = 0;
        st[STARTY][STARTX][1] = 0;
        
        while(!que.isEmpty()){
            Cord cur = que.poll();
            int cy = cur.y; int cx = cur.x; int cw = cur.w; boolean cwid = cur.wid; boolean chei = cur.hei;
            if((cwid && st[cy][cx][0]<cw) || (chei && st[cy][cx][1]<cw)){
                continue;
            }
            
            for(int i=0; i<4; i++){
                int ny = cy+dy[i]; int nx = cx+dx[i]; 
                if(ny<0 || nx<0 || ny>=board.length || nx>=board.length || board[ny][nx]==1){
                    continue;
                }
                
                Cord next = new Cord(ny,nx,0,cwid,chei);
                next.w = cw+getCost(cur, next);
                
                if((next.wid && st[ny][nx][0]<next.w) || (next.hei && st[ny][nx][1]<next.w)){
                    continue;
                }
                
                if(next.wid){
                    st[ny][nx][0] = next.w;
                }
                else{
                    st[ny][nx][1] = next.w;
                }
            
                que.offer(next);
            }
        }
        return Math.min(st[board.length-1][board.length-1][0], st[board.length-1][board.length-1][1]);
    }
    
    int getCost(Cord cur, Cord next){
        int cost = 100;
        if(cur.y==0 && cur.x==0){
            if(cur.y!=next.y){
                next.hei = true;
            }
            else{
                next.wid = true;
            }
        }else{
            if(cur.y!=next.y && cur.wid){
                next.hei = true;
                next.wid = false;
                cost = 600;
            }
            else if(cur.x!=next.x && cur.hei){
                next.hei = false;
                next.wid = true;
                cost = 600;
            }
        }
        return cost;
    }
}


// 직각인지, 그대로 가고 있는지 판단 필요