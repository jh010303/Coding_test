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
			int m = Integer.parseInt(st.nextToken());
			String answer = "";
			
			answer = recurSive(n,m,0)==true?"ON":"OFF";
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static boolean recurSive(int n, int m, int depth) {
		if(depth==n) {
			return true;
		}
		
		if(m%2==0) {
			return false;
		}
		else {
			return recurSive(n,m/2,depth+1);
		}
	}
}