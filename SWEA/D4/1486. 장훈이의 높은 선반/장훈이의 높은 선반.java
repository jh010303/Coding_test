import java.util.*;
import java.io.*;

class Solution
{
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
			int b = Integer.parseInt(st.nextToken());
			int[] hList = new int[n];
			
			int minH = 200001;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				hList[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<(1<<n); i++) {
				int sumH = 0;
				for(int j=0; j<n; j++) {
					if((i & (1<<j))!=0) {
						sumH+=hList[j];
					}
				}
				
				if(sumH>=b) {
					minH = Math.min(minH,sumH-b);
				}
			}
			sb.append("#").append(test_case).append(" ").append(minH).append("\n");
		}
		
		System.out.print(sb);
	}
}