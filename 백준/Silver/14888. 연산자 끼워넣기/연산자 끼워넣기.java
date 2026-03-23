import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] num;
	static int[] oper;
	static int N;
	static int minN = Integer.MAX_VALUE;
	static int maxN = Integer.MIN_VALUE;
	static List<Integer> list =new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());//숫자 갯수
		num = new int[N];//숫자 모음
		oper = new int[4];//각각의 연산자 갯수(덧셈, 뺄셈, 곱셈, 나눗셈 순서)
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료
		
		select(0);
		sb.append(maxN).append("\n").append(minN);
		System.out.println(sb);
		
		

	}
	public static void select(int idx) {
		if(idx == N-1) {
			//연산자를 전부 골랐으면 종료합니다
			int tmp = num[0];
			for(int i =0;i<N-1;i++) {
				if(list.get(i)==0) {
					//덧셈
					tmp+=num[i+1];
				}
				else if(list.get(i)==1) {
					//뺄셈
					tmp-=num[i+1];
				}
				else if(list.get(i)==2) {
					//곱셈
					tmp*=num[i+1];
				}
				else if(list.get(i)==3) {
					//나눗셈
					if(tmp<0) {
						tmp = (int)-(Math.abs(tmp)/num[i+1]);
					}
					else {
						tmp = (int)(tmp/num[i+1]);
					}
				}
			}	
			minN = Math.min(minN, tmp);
			maxN = Math.max(maxN, tmp);
			return;
		}
			//계산
			for(int i =0;i<4;i++) {
				if(oper[i] != 0 ) {
					list.add(i);
					oper[i]--;
					select(idx+1);
					list.remove(list.size()-1);
					oper[i]++;
				}
			}
			
		
	}

}