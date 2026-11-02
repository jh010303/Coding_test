import java.util.*;
import java.io.*;

class Solution
{
	static int[] arr;
	public static void main(String args[]) throws Exception
	{
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int s = 0;
			
			for(int i=0; i<n; i++) {
				s = s^arr[i];
			}
			
			if(s!=0) {
				sb.append("#").append(test_case).append(" ").append("NO").append("\n");
			}
			else {
				Arrays.sort(arr);
				int answer = 0;
				for(int i=1; i<n; i++) {
					answer+=arr[i];
				}
				sb.append("#").append(test_case).append(" ").append(answer).append("\n");
				
			}
		}
		
		System.out.print(sb);
	}
}