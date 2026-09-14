import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int answer = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			int l=0; int r = n-1;
			while(l<r) {
				int sum = arr[l]+arr[r];
				if(sum==m) {
					answer = sum;
					break;
				}
				else if(sum>m) {
					r--;
				}
				else {
					answer = Math.max(answer, sum);
					l++;
				}
			}
			
            sb.append("#").append(test_case).append(" ").append(answer==0?-1:answer).append("\n");
		}
		
		System.out.print(sb);
	}
}