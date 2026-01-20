import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Schedule{
		int t;
		int p;
		
		public Schedule(int t, int p){
			this.t = t;
			this.p = p;
		}
	}
	
	static int n,t,p;
	static List<Schedule> schedules = new ArrayList<>();
	static int[] dp = new int[20];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			schedules.add(new Schedule(t,p));
		}
		
		for(int i=1; i<=n; i++) {
			Schedule temp = schedules.get(i-1);
			t = temp.t; p = temp.p;
			if(i+t-1<=n) {
				dp[i+t] = Math.max(dp[i+t], dp[i]+p);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		
		bw.write(dp[n+1]+"");
		bw.flush();
	}
}
