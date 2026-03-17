import java.io.*;
import java.util.*;

import org.xml.sax.InputSource;

public class Main {
	static class Cord implements Comparable<Cord>{
		int y;
		int x;
		public Cord(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Cord o) {
			if(o.y!=this.y) {
				return this.y-o.y;
			}
			return this.x-o.x;
		}	
	}
	
	static Cord[] cords;
	static int n;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		n = Integer.parseInt(br.readLine());
		cords = new Cord[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cords[i] = new Cord(y,x);
		}
		Arrays.sort(cords);
		for(int i=0; i<n; i++) {
			Cord cur = cords[i];
			sb.append(cur.x).append(" ").append(cur.y).append("\n");
		}
		System.out.print(sb);
	}
}