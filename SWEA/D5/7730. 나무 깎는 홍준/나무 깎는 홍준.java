import java.util.*;
import java.io.*;

class Solution
{
	static int[] trees;
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
			int answer = 0;
			
			trees = new int[n];
			
			int l = 0; int r = -1;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				r = Math.max(r,trees[i]);
			}
			
			while(l<=r) {
				int mid = (l+r)/2;
				long h = getH(mid);
				if(h>=m) {
					l = mid+1;
					answer = mid;
				}else{
					r = mid-1;
				}

			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static long getH(int mid) {
		long h = 0;
		for(int i=0; i<trees.length; i++) {
			if(trees[i]>mid) {
				h+=(trees[i]-mid);
			}
		}
		
		return h;
	}
}

// 자른 나무의 합이 m보다 작으면 나무 자르는 위치를 줄여야 함
// 자른 나무의 합이 m보다 크면 정답 갱신하고 나무 자르는 위치를 높혀야 함