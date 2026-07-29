import java.util.*;
import java.io.*;

class Solution
{
    static class Cord{
    	int y;
        int x;
        public Cord(int y, int x){
        	this.y = y;
            this.x = x;
        }
    }
    
    static boolean[] visited;
    static Cord[] cords;
    static int answer = Integer.MAX_VALUE;
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
            cords = new Cord[n];
            visited = new boolean[n];
            answer = Integer.MAX_VALUE;
            
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            
            for(int i=0; i<n; i++){
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
            	cords[i] = new Cord(y,x);
            }
            
            for(int i=0; i<n; i++){
                visited[i] = true;
                int cy = cords[i].y; int cx = cords[i].x;
            	backTracking(Math.abs(sy-cy)+Math.abs(sx-cx),1,n,cy,cx,ey,ex);
                visited[i] = false;
            }
            
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
    
    static void backTracking(int len, int cnt, int n, int cy, int cx, int ey, int ex){
        if(cnt==n){
            len+=(Math.abs(ey-cy)+Math.abs(ex-cx));
            answer = Math.min(answer,len);
            return;
        }
        
        for(int i=0; i<n; i++){
        	if(!visited[i]){
            	visited[i] = true;
                int y = cords[i].y; int x = cords[i].x;
                backTracking(len+Math.abs(cy-y)+Math.abs(cx-x), cnt+1,n,y,x,ey,ex);
                visited[i] = false;
            }
        }
        
        
    }
    
    static int getD(int y2, int x2, int y1, int x1){
    	return Math.abs(y2-y1)+Math.abs(x2-x1);
    }
}