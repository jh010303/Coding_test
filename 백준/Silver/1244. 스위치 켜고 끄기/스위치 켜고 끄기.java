import java.util.*;
import java.io.*;

public class Main {
	static class Student{
		int g;
		int n;
		public Student(int g, int n) {
			super();
			this.g = g;
			this.n = n;
		}
	}
	
	static int ledCnt, studentCnt;
	static int[] led;
	static List<Student> students = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ledCnt = Integer.parseInt(br.readLine());
		init();
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=ledCnt; i++) {
			led[i] = Integer.parseInt(st.nextToken());
		}
		
		
		studentCnt = Integer.parseInt(br.readLine());
		for(int i=0; i<studentCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			students.add(new Student(g,n));
		}
		
		for(int i=0; i<students.size(); i++) {
			Student curStudent = students.get(i);
			int g = curStudent.g; int n = curStudent.n;
			if(g==1) {
				for(int j=1; j<=ledCnt; j++) {
					if(j%n==0) {
						toggle(j);
					}
				}
			}
			else {
				toggle(n);
				int j=1;
				while(n-j>=1 && n+j<=ledCnt) {
					if(led[n-j]==led[n+j]) {
						toggle(n-j);
						toggle(n+j);
					}
					else {
						break;
					}
					j++;
				}
			}
		}
		
		for(int i=1; i<=ledCnt; i++) {
			sb.append(led[i]).append(" ");
            if(i%20==0)sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static void toggle(int n) {
		if(led[n]==0) {
			led[n]=1;
		}else {
			led[n]=0;
		}
	}
	
	static void init() {
		led = new int[ledCnt+1];
	}

}
