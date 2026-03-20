import java.io.*;
import java.util.*;

public class Main {
	static int ans = Integer.MAX_VALUE;
	static int n;
	static int[][] skill;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		skill = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				skill[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<(1<<n); i++) {
			if(Integer.bitCount(i)==n/2) {
				List<Integer> list1 = new ArrayList<>();
				List<Integer> list2 = new ArrayList<>();
				int sum1 = 0; int sum2 = 0;
				for(int j=0; j<n; j++) {
					if((i&(1<<j))!=0) {
						list1.add(j);
					}
					else {
						list2.add(j);
					}
				}
				sum1 = getSum(list1);
				sum2 = getSum(list2);
				ans = Math.min(ans, Math.abs(sum1-sum2));
			}
		}
		System.out.println(ans);
	}
	
	static int getSum(List<Integer> list) {
		int sum = 0;
		for(int i=0; i<list.size()-1; i++) {
			for(int j=i+1; j<list.size(); j++) {
				sum+=skill[list.get(i)][list.get(j)];
				sum+=skill[list.get(j)][list.get(i)];
			}
		}
		return sum;
	}
}