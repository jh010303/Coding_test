import java.util.*;
import java.io.*;

class Solution
{
    static double[][] works;
    static boolean[] visited;
    static double answer;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
            works = new double[n][n];
            visited = new boolean[n];
            answer = 0.0;
            
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
            	for(int j=0; j<n; j++){
                    works[i][j] = Integer.parseInt(st.nextToken())/100.0;
                }
            }
            
            backTracking(0, 100.0, visited, n);
           
            sb.append("#").append(test_case).append(" ").append(String.format("%.6f", answer)).append("\n");
		}
        
        System.out.print(sb);
	}
    
    static void backTracking(int cnt, double per, boolean[] visited, int n){
    	if(per<=answer){
        	return;
        }
    	
    	if(cnt==n){
        	answer = per;
        }
  
    
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                backTracking(cnt+1,per*works[cnt][i],visited,n);
                visited[i] = false;
            }
        }
    }
}