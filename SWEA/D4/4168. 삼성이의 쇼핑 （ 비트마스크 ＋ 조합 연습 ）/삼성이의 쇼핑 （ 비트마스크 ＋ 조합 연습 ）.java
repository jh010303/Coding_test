import java.util.*;
import java.io.*;

class Solution
{
	static class Clothes{
		int p;
		int s;
		public Clothes(int p, int s) {
			this.p = p;
			this.s = s;
		}
	}
	
	static Clothes[] clothesList;
	static List<Integer> answerList = new ArrayList<>();
	static int answer;
	static int n,m;
	
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			clothesList = new Clothes[m];
			answerList.clear();
			answer = 0;
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				clothesList[i] = new Clothes(p,s);
			}
			
			List<Integer> trace = new ArrayList<>();
			combine(0,0,trace,0);
			
            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<answerList.size(); i++) {
            	sb.append(answerList.get(i)).append(" ");
            }
            sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
	static void combine(int p, int s, List<Integer> trace, int depth) {
		if(p>=n) {
			return;
		}
		
		if(depth==m) {
			if(s>answer) {
				answerList = new ArrayList<>(trace);
				answer = s;
			}
			return;
		}
		
		combine(p,s,trace,depth+1);
		
		trace.add(depth);
		combine(p+clothesList[depth].p, s+clothesList[depth].s, trace, depth+1);
		trace.remove((int)trace.size()-1);
	}
    
    
}