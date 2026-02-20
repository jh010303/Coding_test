import java.io.*;
import java.util.*;

public class Main {
	static class Game implements Comparable<Game> {
		int x;
		int cnt;

		public Game(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Game o) {
			return this.cnt-o.cnt;
		}
	}

	static int n, m, ans=101;
	static int[] snake = new int[101];
	static int[] ladder = new int[101];
	static int[] cnt = new int[101];
	static PriorityQueue<Game> que = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		initArray();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ladder[start] = end;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			snake[start] = end;
		}

		que.offer(new Game(1,0));
		
		while (!que.isEmpty()) {
			Game cur = que.poll();
			int curX = cur.x, curCnt = cur.cnt;
			
			if (curX >= 100) {
				ans = Math.min(ans, curCnt);
				continue;
			}
			
			if(curCnt>cnt[curX]) {
				continue;
			}
			
			cnt[curX] = curCnt;
			
			if (snake[curX] > 0) {
				if(cnt[snake[curX]]<curCnt)continue;
				que.offer(new Game(snake[curX],curCnt));
				
			} else if (ladder[curX] > 0) {
				if(cnt[ladder[curX]]<curCnt)continue;
				que.offer(new Game(ladder[curX],curCnt));
			} else {
				for (int i = curX + 1; i <= curX + 6; i++) {
					if(i>100)break;
					if(cnt[i]<curCnt+1)continue;
					que.offer(new Game(i,curCnt+1));
				}
			}
		}

		System.out.print(ans);
	}

	static void initArray() {
		Arrays.fill(snake, -1);
		Arrays.fill(ladder, -1);
		Arrays.fill(cnt, 10001);
	}
}