import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution
{
	static int t,n,b,min=Integer.MAX_VALUE,sum=0;
	static int[] arr = new int[21];
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			min=Integer.MAX_VALUE; sum=0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			backtracking(0,0);
			System.out.println("#"+test_case+" "+(min-b));
		}
	}
	
	static void backtracking(int sum,int depth) {
		if(sum>=b || depth>=n) {
			if(sum<b)return;
			min = Integer.min(sum, min);
			return;
		}
		backtracking(sum+arr[depth],depth+1);
		backtracking(sum,depth+1);
	}
}