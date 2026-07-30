import java.util.*;
import java.io.*;

class Solution
{
    static class Hambuk{
        int t;
        int k;
        public Hambuk(int t, int k){
        	this.t = t;
            this.k = k;
        }
    }
    
    static Hambuk[] hambuks;
    static boolean[] visited;
    static int answer;
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            hambuks = new Hambuk[n];
            visited = new boolean[n];
            answer = 0;
            
            for(int i=0; i<n; i++){
            	st = new StringTokenizer(br.readLine());
                hambuks[i] = new Hambuk(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            
            backTracking(n,l,0,0,0);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
    
    static void backTracking(int n, int l, int cur, int totalT, int totalK){
    	if(totalK >l){
        	return;
        }

        answer = Math.max(answer,totalT);
        
        if(cur==n){
        	return;
        }
        
        backTracking(n,l,cur+1,totalT,totalK);
        backTracking(n,l,cur+1,totalT+hambuks[cur].t, totalK+hambuks[cur].k);
    }
             
}