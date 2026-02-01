import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] price;
	static int[] dp;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        price = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
        	price[i] = Integer.parseInt(st.nextToken());
        	dp[i] = price[i];
        }
        for(int i=2; i<=n; i++) {
        	for(int k=1; k<=i/2; k++) {
        		dp[i] = Math.max(dp[i], dp[i-k]+dp[k]);   
        	}
        }
        System.out.print(dp[n]);
    }
}
