import java.io.*;
import java.util.*;

public class Main {
	static int n,s,len = Integer.MAX_VALUE;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start=0,end=0;
		long sum = 0;
		
		while(start<=end) {
			if(sum<s) {
				if(end>=n)break;
				sum+=arr[end++];
			}
			else {
				len = Math.min(len, end-start);
				sum-=arr[start++];
			}
		}
		
		System.out.print(len==Integer.MAX_VALUE?0:len);
	}
}