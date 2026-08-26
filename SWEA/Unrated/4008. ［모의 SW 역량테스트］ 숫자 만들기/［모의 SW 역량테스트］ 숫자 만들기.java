import java.util.*;
import java.io.*;

class Solution
{
	static int[] opCnt = new int[4];
	static char[] op = {'+','-','*','/'};
	static int[] nums;
	static int n,maxA,minA;
	
	public static void main(String args[]) throws Exception
	{
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			
			maxA = -100000000; minA = 100000000;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				opCnt[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(nums[0],0);
			
			sb.append("#").append(test_case).append(" ").append(maxA-minA).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int cur, int depth) {
		if(depth==n-1) {
			maxA = Math.max(maxA,cur);
			minA = Math.min(minA,cur);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(opCnt[i]>0) {
				opCnt[i]--;
				if(op[i]=='+') {
					dfs(cur+nums[depth+1],depth+1);
				}else if(op[i]=='-') {
					dfs(cur-nums[depth+1],depth+1);
				}else if(op[i]=='*') {
					dfs(cur*nums[depth+1],depth+1);
				}else if(op[i]=='/') {
					dfs(cur/nums[depth+1],depth+1);
				}
				opCnt[i]++;
			}
		}
	}
}