import java.util.*;
import java.io.*;

class Solution
{
    static PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b)->{
    	return b-a;
    });
    
    static PriorityQueue<Integer> minQ = new PriorityQueue<>();
    
	public static void main(String args[]) throws Exception
	{
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int sum = 0;
            maxQ.clear();
            minQ.clear();
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
            	if(n1<=a){
                	 maxQ.offer(n1);	
                }else{
                	minQ.offer(n1);
                }
              
                int n2 = Integer.parseInt(st.nextToken());
                if(n2<=a){
                	 maxQ.offer(n2);	
                }else{
                	minQ.offer(n2);
                }
               
                if(maxQ.size()>minQ.size()){
                	minQ.offer(a);
                    a = maxQ.poll();
                    
                }
                else if(maxQ.size()<minQ.size()){
                    maxQ.offer(a);
                	a = minQ.poll();
                }
                
                sum = (sum+a)%20171109;
            }
            sb.append("#").append(test_case).append(" ").append(sum).append('\n');
		}
        System.out.print(sb);
        
	}
}