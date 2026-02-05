import java.io.*;
import java.util.*;

public class Main {
	static int n,min = Integer.MAX_VALUE, max = Integer.MIN_VALUE,mid,mostCountNum;
	static double sum=0;
	static HashMap<Integer,Integer> cnt = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		n = Integer.parseInt(br.readLine());
		int temp;
		for(int i=0; i<n; i++) {
			temp = Integer.parseInt(br.readLine());
			sum+=temp;
			cnt.put(temp, cnt.getOrDefault(temp, 0)+1);
			min = Math.min(temp, min);
			max = Math.max(temp, max);
		}	
		
		int count = 0, ansIndex=0;
		for(int i=-4000; i<=4000; i++) {
			count = cnt.getOrDefault(i, 0);
			if(count==0)continue;
			ansIndex+=count;
			if(ansIndex>n/2) {
				mid = i;
				break;
			}
		}
		int minV = Integer.MIN_VALUE;
		int mostCount=0;
		for(int i=-4000; i<=4000; i++) {
			count = cnt.getOrDefault(i, 0);
			if(count==0)continue;
			if(minV<=count) {
				if(minV<count) {
					mostCount=0;
				}
				else {
					mostCount++;
				}
				if(mostCount>2) {
					continue;
				}
				minV = count;
				mostCountNum = i;
				mostCount++;
			}
		}
		double avg = sum/n;
		
		sb.append((int)Math.round(avg)).append("\n").append(mid).append("\n").append(mostCountNum).append("\n")
		.append(max-min);
		System.out.print(sb);
	}
}
