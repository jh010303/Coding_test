import java.io.*;
import java.util.*;

public class Main {
	static int n, m, b, minH = Integer.MAX_VALUE, maxH = Integer.MIN_VALUE, 
			ansH, ansT= Integer.MAX_VALUE;
	static int[] blockCnt = new int[257];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int h = Integer.parseInt(st.nextToken());
				blockCnt[h]++;
				minH = Math.min(minH, h);
				maxH = Math.max(maxH, h);
			}
		}

		for (int h = maxH; h >= minH; h--) {
			int t = getTime(h);
			if(ansT>t) {
				ansT = t;
				ansH = h;
			}
		}
		System.out.print(ansT + " " + ansH);
	}

	static int getTime(int targetH) {
		int time = 0, inven = b;
		for (int h = 256; h >= 0; h--) {
			if (blockCnt[h] > 0) {
				if (h > targetH) {
					time += ((h - targetH) * blockCnt[h] * 2);
					inven += ((h - targetH) * blockCnt[h]);
				} else {
					time += ((targetH-h) * blockCnt[h]);
					inven -= ((targetH-h) * blockCnt[h]);
					if(inven<0) {
						return Integer.MAX_VALUE;						
					}
				}
			}
		}
		return time;
	}
}
