import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int t,n,max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] numList;
	static int[] opCnt = { 0, 0, 0, 0 };
	static char[] op = {'+','-','*','/'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			n = Integer.parseInt(br.readLine());
			numList = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				opCnt[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				numList[i] = Integer.parseInt(st.nextToken());
			}
			
			
			backTracking(numList[0],0);
			sb.append("#").append(test_case).append(" ").append(max-min).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void backTracking(int sum, int depth) {
		if(depth==n-1) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(opCnt[i]>0) {
				opCnt[i]--;
				if(op[i]=='+') {
					backTracking(sum+numList[depth+1], depth+1);
				}
				else if(op[i]=='-') {
					backTracking(sum-numList[depth+1], depth+1);
				}
				else if(op[i]=='*') {
					backTracking(sum*numList[depth+1], depth+1);
				}
				else if(op[i]=='/') {
					backTracking(sum/numList[depth+1], depth+1);
				}
				opCnt[i]++;
			}
		}
	}
	
	
	static void init() {
		Arrays.fill(opCnt, 0);
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}
}
