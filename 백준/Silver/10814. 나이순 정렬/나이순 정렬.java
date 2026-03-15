import java.io.*;
import java.util.*;

public class Main {
	static int n;
	
	static class Member implements Comparable<Member>{
		int age;
		String name;
		
		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Member m) {
			return this.age-m.age;
		}
	}
	
	static Member[] members;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		members = new Member[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			members[i] = new Member(age,name);
		}
		
		Arrays.sort(members);
		
		for(int i=0; i<n; i++) {
			sb.append(members[i].age).append(" ").append(members[i].name).append("\n");
		}
		System.out.print(sb);
	}
}